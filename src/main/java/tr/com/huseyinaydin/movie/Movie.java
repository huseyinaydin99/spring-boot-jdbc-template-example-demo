package tr.com.huseyinaydin.movie;

import tr.com.huseyinaydin.actor.Actor;

import java.time.LocalDate;
import java.util.List;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    LocalDate releaseDate) {
}