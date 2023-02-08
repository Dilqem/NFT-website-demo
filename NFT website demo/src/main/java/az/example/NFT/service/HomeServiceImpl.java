package az.example.NFT.service;

import az.example.NFT.repository.GalleryRepository;
import az.example.NFT.repository.ImageRepository;
import az.example.NFT.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final UserRepository ur;
    private final GalleryRepository gr;
    private final FileLocationService fls;

    public HomeServiceImpl(UserRepository hr, GalleryRepository gr, FileLocationService fls) {
        this.ur = hr;
        this.gr = gr;
        this.fls = fls;
    }

    @Override
    public List<Object> searchQuery(String query) {
        return List.of(gr.searchGalleries(query), ur.searchUsers(query), fls.searchQuery(query));
    }
}
