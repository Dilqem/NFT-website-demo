package az.example.NFT.springsecurity.controllers;

import az.example.NFT.springsecurity.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/test")
public class TestController {
  private final TestService service;

  public TestController(TestService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public String allAccess() {
    return service.allAccess();
  }

  @GetMapping("/user")
  public String userAccess() {
    return service.userAccess();
  }

  @GetMapping("/mod")
  public String moderatorAccess() {
    return service.moderatorAccess();
  }

  @GetMapping("/admin")
  public String adminAccess() {
    return service.adminAccess();
  }
}
