package az.example.NFT.model;

import az.example.NFT.springsecurity.models.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "galleries",uniqueConstraints = @UniqueConstraint(columnNames = {"gallery_id"}))
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "gallery_id", nullable = false)
    private Long id;
    private String name;
    private String about;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_galleries",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "gallery_id"))
    private User user;

    @OneToMany(targetEntity = Image.class, fetch = FetchType.EAGER)
    private List<MultipartFile> imageList;

}
