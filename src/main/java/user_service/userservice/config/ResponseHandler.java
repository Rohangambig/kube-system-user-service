package user_service.userservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter
@Setter
public class ResponseHandler {
    
    private String message;
    private HttpStatus status;
    private Object data;

    ResponseEntity<ResponseHandler> handleResponse( String message, HttpStatus status, Object data) {

        ResponseHandler res = new ResponseHandler(
            message, status, data
        );

        return new ResponseEntity<>(res,status);

    }

}
