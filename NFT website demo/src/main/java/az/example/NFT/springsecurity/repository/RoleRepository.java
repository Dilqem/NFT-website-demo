package az.example.NFT.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import az.example.NFT.springsecurity.models.ERole;
import az.example.NFT.springsecurity.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  @Query(value = "select r from Role r where r.name=?1")
  Optional<Role> findByName(ERole name);
}
