package az.example.NFT.springsecurity.service;

import az.example.NFT.springsecurity.payload.request.LoginRequest;
import az.example.NFT.springsecurity.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthService {
     ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);
     ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
}
