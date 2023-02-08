package az.example.NFT.repository;

import az.example.NFT.model.Image;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i FROM Image i WHERE " +
            "i.name LIKE CONCAT('%',:query, '%')"
           + "Or i.description LIKE CONCAT('%', :query, '%')")
    List<Image> searchImages(String query);
}
