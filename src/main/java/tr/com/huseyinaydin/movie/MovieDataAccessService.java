package tr.com.huseyinaydin.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

@Repository
public class MovieDataAccessService implements MovieDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql = """
                SELECT id, name, release_date
                FROM movie
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = """
                INSERT INTO movie(name, release_date)
                VALUES (?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                movie.name(), movie.releaseDate()
        );
    }

    @Override
    public int deleteMovie(int id) {
        var sql = """
                DELETE FROM movie   
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = """
                SELECT id, name, release_date
                FROM movie
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }

}
