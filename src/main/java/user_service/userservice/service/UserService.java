package  user_service.userservice.service;

import user_service.userservice.config.ResponseHandler;
import org.springframework.http.ResponseEntity;
import user_service.userservice.DTO.userRequest.*;

public interface UserService {
    ResponseEntity<ResponseHandler> registerUser(UserRequestDTO requests);
}
