package az.example.NFT.repository;

import az.example.NFT.springsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository<User,Long> {
    @Query("SELECT p FROM User p WHERE " +
            "p.username LIKE CONCAT('%',:query, '%')" )
//           + "Or p. LIKE CONCAT('%', :query, '%')")
    List<Object> searchUsers(String query);
}
