package az.example.NFT.controller;

import az.example.NFT.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/ictimai")
public class Home {
    private final HomeService hs;

    public Home(HomeService hs) {
        this.hs = hs;
    }


    @GetMapping("/axtar")
    ResponseEntity<List<Object>> search(@RequestParam("query") String query) {
        return ResponseEntity.ok(hs.searchQuery(query));
    }
}
