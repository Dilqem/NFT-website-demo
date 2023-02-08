package az.example.NFT.model;

import az.example.NFT.springsecurity.models.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "img_id", nullable = false)
    private Long id;
    @Lob
    byte[] content;
    private String name;
    private String location;
    private String description;
    private int sale_start_day;
    private int sale_end_day;
    private Long cost;
    @Transient
    private HashMap<Integer, Long> costChanging = new HashMap<>();
    private String history;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_imges",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "img_id"))
    private User user;

    public Image(String imageName, String location) {
        this.name = imageName;
        this.location = location;
    }
}