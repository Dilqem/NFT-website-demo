package az.example.NFT.service;

import az.example.NFT.model.Image;
import az.example.NFT.repository.FileSystemRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import az.example.NFT.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileLocationServiceImpl implements FileLocationService {

    private final FileSystemRepository fileSystemRepository;
    private final ImageRepository imageRepository;

    FileLocationServiceImpl(FileSystemRepository fsr, ImageRepository imgRepo) {
        this.fileSystemRepository = fsr;
        this.imageRepository = imgRepo;
    }

    @Override
    public Long save(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);

        return imageRepository.save(new Image(imageName, location))
                .getId();
    }

    @Override
    public FileSystemResource find(Long imageId) {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(image.getLocation());
    }

    @Override
    public List<FileSystemResource> searchQuery(String query) {
        List<FileSystemResource> imageList = new ArrayList<>();
        List<Image> images = imageRepository.searchImages(query);
        images.iterator().forEachRemaining(image ->
                imageList.add(fileSystemRepository.findInFileSystem(image.getLocation())));
        return imageList;
    }
}
