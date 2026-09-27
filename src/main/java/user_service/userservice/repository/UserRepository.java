package user_service.userservice.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import user_service.userservice.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, UUID>{

    @Query("SELECT u FROM UserModel u WHERE u.email= :email ")
    public UserModel ExistsByEmail(@Param(value="email") String email);

}
