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
import user_service.userservice.DTO.userRequest.UserLoginRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserServiceImplementation implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<ResponseHandler> registerUser(UserRequestDTO requests) {

        log.info("Registering user with email: {} {} ", requests.getEmail(), requests.getUname());

        UserModel userExist = userRepository.ExistsByEmail(requests.getEmail());

        if (userExist != null) {
            log.error("Email already exists: {}", requests.getEmail());
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String password = requests.getPassword();
        // String encodedPassword = passwordEncoder.encode(password);

        UserModel user = new UserModel(
            requests.getUname(),
            requests.getEmail(),
            password
        );

        userRepository.save(user);
        log.info("Registered the email: {}", requests.getEmail());
        return new ResponseEntity<>(
            new ResponseHandler(
                "User registered their email",
                HttpStatus.CREATED,
                null
            ),
            HttpStatus.CREATED
        );
    }


    @Override 
    public ResponseEntity<ResponseHandler> loginUser(UserLoginRequestDTO requests) {
        log.info("Logging in user with email: {}", requests.getEmail());
        if( requests.getEmail() == null || requests.getPassword() == null) {
            log.error("Email and password must not be null");
            throw new IllegalArgumentException("Email and password must not be null");
        }

        UserModel user = userRepository.ExistsByEmail(requests.getEmail());

        if( user == null){
            log.error("User with the provided email does not exist: {}", requests.getEmail());
            throw new IllegalArgumentException("User with the provided email does not exist");
        }

        // String encodedPassword = passwordEncoder.encode(requests.getPassword());

        if( !user.getPassword().equals(requests.getPassword())) {
            log.error("Invalid password for email: {}", requests.getEmail());
            throw new IllegalArgumentException("Invalid password");
        }

        log.info("User Logged in {}",requests.getEmail());
        return new ResponseEntity<>(
            new ResponseHandler(
                "User logged in successfully",
                HttpStatus.OK,
                null
            ),
            HttpStatus.OK
        );

    }

    // @Override 
    // public ResponseEntity<ResponseHandler> customUserDetails(String email) {
    //     UserModel user = userRepository.ExistsByEmail(email);
    //     if (user == null) {
    //         throw new IllegalArgumentException("User with the provided email does not exist");
    //     }
    //     return new ResponseEntity<>(
    //         new ResponseHandler(
    //             "User details retrieved successfully",
    //             HttpStatus.OK,
    //             user
    //         ),
    //         HttpStatus.OK
    //     );
    // }

}
