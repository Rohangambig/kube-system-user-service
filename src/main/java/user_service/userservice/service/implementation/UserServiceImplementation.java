package user_service.userservice.service.implementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import user_service.userservice.DTO.userRequest.UserRequestDTO;
import user_service.userservice.config.EmailAlreadyExistsException;
import user_service.userservice.config.ResponseHandler;
import user_service.userservice.model.UserModel;
import user_service.userservice.repository.UserRepository;
import user_service.userservice.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ResponseHandler> registerUser(UserRequestDTO requests) {

        UserModel userExist = userRepository.ExistsByEmail(requests.getEmail());

        if (userExist != null) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        UserModel user = new UserModel(
            requests.getUname(),
            requests.getEmail(),
            requests.getPassword()
        );

        userRepository.save(user);

        return new ResponseEntity<>(
            new ResponseHandler(
                "User registered their email",
                HttpStatus.CREATED,
                null
            ),
            HttpStatus.CREATED
        );
    }

}
