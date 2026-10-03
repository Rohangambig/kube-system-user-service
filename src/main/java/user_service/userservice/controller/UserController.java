package user_service.userservice.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import user_service.userservice.DTO.userRequest.*;
import user_service.userservice.config.ResponseHandler;
import user_service.userservice.service.*;
import jakarta.validation.Valid;

@RestController
class UserController {

    private final UserService userservice;

    public UserController(UserService userService) {
        this.userservice = userService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "User service is up and running!";
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseHandler> registerUser(@Valid@RequestBody UserRequestDTO requests) {
        
        return userservice.registerUser(requests);

    }
    
    @PostMapping("/login")
    public ResponseEntity<ResponseHandler> loginUser(@Valid @RequestBody UserLoginRequestDTO requests) {
        return userservice.loginUser(requests);
    }
}