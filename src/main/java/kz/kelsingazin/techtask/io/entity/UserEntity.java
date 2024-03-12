package kz.kelsingazin.techtask.io.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @OneToMany(mappedBy = "userDetails",
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ReviewEntity> reviews;
}
