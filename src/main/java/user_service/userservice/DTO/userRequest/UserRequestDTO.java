package user_service.userservice.DTO.userRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data 
public class UserRequestDTO {
    
    @NotBlank(message="Please enter username")
    @Size(min=4,max=15,message="Username must contains max 15 characters")
    @NotNull(message="Please enter username")
    private String uname;
    
    @NotNull(message="Please enter your email")
    private String email;

    @NotBlank(message = "Please enter your password")
    @Size(min=8,message="Password must container atleast 8 and max 12 character")
    private String password;
}
