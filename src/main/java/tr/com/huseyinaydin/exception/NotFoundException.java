package tr.com.huseyinaydin.exception;

/**
 *
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot JDBC Template Demo
 *
 **/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
