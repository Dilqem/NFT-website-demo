package az.example.NFT.service;

import az.example.NFT.exception.NotEnoughPhotoException;
import az.example.NFT.model.Gallery;
import az.example.NFT.repository.GalleryRepository;
import az.example.NFT.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class NFTServiceImpl implements NFTService {
    private final GalleryRepository gr;
    private final FileLocationService fls;
    private final UserRepository ur;

    public NFTServiceImpl(GalleryRepository gr, FileLocationService fls, UserRepository ur) {
        this.gr = gr;
        this.fls = fls;
        this.ur = ur;
    }

    @Override
    public List<Gallery> getGalleries() {
        return gr.findAll();
    }

    @Override
    public Gallery getGallery(Long id) {
        return gr.getById(id);
    }

    @Override
    public Gallery saveGallery(Gallery gallery) throws Exception {
        if (gallery.getImageList().size() < 2) {
            throw new NotEnoughPhotoException();
        }
        Iterator<MultipartFile> iterator = gallery.getImageList().iterator();
        while (iterator.hasNext()) {
            fls.save(iterator.next().getBytes(), iterator.next().getOriginalFilename());
        }
        return gr.save(gallery);
    }

    @Override
    public Optional<Gallery> updateGallery(Long id, Gallery newGallery) {

        return Optional.of(gr.findById(id)
                .map(gallery -> {
                    gallery.setName(newGallery.getName());
                    gallery.setAbout(newGallery.getAbout());
                    gallery.setUser(newGallery.getUser());
                    gallery.setImageList(newGallery.getImageList());
                    return gr.save(gallery);
                })
                .orElseGet(() -> {
                    newGallery.setId(id);
                    return gr.save(newGallery);
                }));
    }

}
