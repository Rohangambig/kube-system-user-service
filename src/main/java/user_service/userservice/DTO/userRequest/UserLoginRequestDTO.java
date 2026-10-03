package user_service.userservice.DTO.userRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class UserLoginRequestDTO {

    @NotBlank(message="Please enter your email")
    private String email;

    @NotBlank(message="Please enter your password")
    @Size(min=8,message="Password must contain at least 8 and max 12 characters")
    private String password;

    UserLoginRequestDTO() {

    }

    UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}