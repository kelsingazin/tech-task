package kz.kelsingazin.techtask.io.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import kz.kelsingazin.techtask.shared.dto.ReviewDto;
import lombok.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double rating;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity userDetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductEntity productDetails;

    public static ReviewEntity fromReviewDto(ReviewDto reviewDto,
                                             UserEntity user,
                                             ProductEntity product) {
        return ReviewEntity.builder()
                .rating(reviewDto.getRating())
                .comment(reviewDto.getComment())
                .userDetails(user)
                .productDetails(product)
                .build();
    }
}
