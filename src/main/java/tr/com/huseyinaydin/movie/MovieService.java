package tr.com.huseyinaydin.movie;

import tr.com.huseyinaydin.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        // TODO: check if movie exists
        int result = movieDao.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("Kayıt girilemedi!");
        }
    }

    public void deleteMovie(Integer id) {
        Optional<Movie> movies = movieDao.selectMovieById(id);
        movies.ifPresentOrElse(movie -> {
            int result = movieDao.deleteMovie(id);
            if (result != 1) {
                throw new IllegalStateException("Film silinemedi. Hata!");
            }
        }, () -> {
            throw new NotFoundException(String.format("İlgili film bulunamadı. Film No: %s", id));
        });
    }

    public Movie getMovie(int id) {
        return movieDao.selectMovieById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Film bulunamadı. Film No: %s", id)));
    }
}