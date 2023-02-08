package az.example.NFT.service;


import org.springframework.core.io.FileSystemResource;

import java.util.List;

public interface FileLocationService {

    Long save(byte[] bytes, String imageName) throws Exception;

    FileSystemResource find(Long imageId);

    List<FileSystemResource> searchQuery(String query);
}
