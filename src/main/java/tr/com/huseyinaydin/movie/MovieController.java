package tr.com.huseyinaydin.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public Movie getMovieId(@PathVariable("id") Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovie(id);
    }

   // TODO: Update movie
}
