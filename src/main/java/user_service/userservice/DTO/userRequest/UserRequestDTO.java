package user_service.userservice.DTO.userRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data 
public class UserRequestDTO {
    
    @NotBlank(message="Please enter username")
    @Min(value=4,message="Username must contains atleast 4 character")
    @Max(value=15,message="Username must contains max 15 characters")
    private String uname;
    
    @NotNull(message="Please enter your email")
    private String email;

    @NotBlank(message = "Please enter your password")
    @Min(value=8, message="Password must container atleast 12 character")
    private String password;
}
