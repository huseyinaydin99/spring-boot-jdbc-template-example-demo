package tr.com.huseyinaydin.movie;

import java.util.List;
import java.util.Optional;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
    // TODO: Update
}
