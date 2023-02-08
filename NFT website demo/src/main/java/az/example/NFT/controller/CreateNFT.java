package az.example.NFT.controller;

import az.example.NFT.model.Gallery;
import az.example.NFT.service.FileLocationService;
import az.example.NFT.service.NFTService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user/NFTyukle")
public class CreateNFT {
    private final NFTService nftService;
    final private FileLocationService fileLocationService;

    public CreateNFT(NFTService nftService, FileLocationService fileLocationService) {
        this.nftService = nftService;
        this.fileLocationService = fileLocationService;
    }

    @PostMapping("/yeniQalereya")
    Gallery uploadGallery(@RequestBody Gallery gallery) throws Exception {
        return nftService.saveGallery(gallery);
    }

    @PostMapping("/tekYukle")
    Long uploadImage(@RequestParam List<MultipartFile> imageList) throws Exception {
        return fileLocationService.save(imageList.listIterator().next().getBytes(),
                imageList.listIterator().next().getOriginalFilename());
    }

    @GetMapping("/galereyalar")
    List<Gallery> getGalleries() {
        return nftService.getGalleries();
    }

    @GetMapping("/galereyalar/{id}")
    Gallery getGallery(@PathVariable Long id) {
        return nftService.getGallery(id);
    }

    @PostMapping("/galereyalar/{id}")
    Optional<Gallery> updateGallery(@PathVariable Long id,
                                    @RequestBody Gallery gallery) {
        return nftService.updateGallery(id, gallery);
    }
}
