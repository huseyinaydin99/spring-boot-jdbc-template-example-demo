package tr.com.huseyinaydin.movie;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

class MovieControllerTest {

    @Mock
    private MovieService movieService;

    private MovieController underTest;

    @BeforeEach
    void setUp() {
        underTest = new MovieController(movieService);
    }
}