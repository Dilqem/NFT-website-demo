package az.example.NFT.service;

import az.example.NFT.model.Gallery;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NFTService{
    List<Gallery> getGalleries();

    Gallery getGallery(Long id);

    Gallery saveGallery(Gallery gallery) throws Exception;

    Optional<Gallery> updateGallery(Long id, Gallery gallery);
}
