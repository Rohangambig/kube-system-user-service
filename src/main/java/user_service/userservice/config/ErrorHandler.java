package user_service.userservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseHandler> internalServerError(Exception e) {
        return new ResponseEntity<>(
            new ResponseHandler(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                null
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ResponseHandler> emailAlreadyExists(EmailAlreadyExistsException e) {
        return new ResponseEntity<>(
            new ResponseHandler(
                e.getMessage(),
                HttpStatus.CONFLICT,
                null
            ),
            HttpStatus.CONFLICT
        );
    }

}
