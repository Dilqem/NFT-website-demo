package az.example.NFT.springsecurity.service;

import org.springframework.stereotype.Service;


public interface TestService {
    String allAccess();
    String userAccess();
    String moderatorAccess();
    String adminAccess();
}
