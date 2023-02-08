package az.example.NFT.repository;

import az.example.NFT.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    @Query("SELECT g FROM Gallery g WHERE " +
            "g.name LIKE CONCAT('%',:query, '%')" +
            "Or g.about LIKE CONCAT('%', :query, '%')")
    List<Object> searchGalleries(String query);
}
