package az.example.NFT.springsecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import az.example.NFT.springsecurity.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT p FROM User p WHERE " +
            "p.username LIKE CONCAT('%',:query, '%')")
    List<Object> searchUsers(String query);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
