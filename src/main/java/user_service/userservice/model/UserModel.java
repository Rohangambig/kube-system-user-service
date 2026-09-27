package user_service.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name="users") 
@Getter 
@Setter
@AllArgsConstructor 
@NoArgsConstructor 
public class UserModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable=false)
    private String uname;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;
    
    public UserModel(String uname, String email, String password) {
        this.uname = uname;
        this.email = email;
        this.password = password;
    }
}
