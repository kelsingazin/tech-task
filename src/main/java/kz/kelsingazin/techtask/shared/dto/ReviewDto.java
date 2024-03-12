package kz.kelsingazin.techtask.shared.dto;

import kz.kelsingazin.techtask.io.entity.ReviewEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReviewDto {

    private Long id;
    private Double rating;
    private String comment;
    private Long userId;
    private Long productId;
    private Date createdAt;

    public static ReviewDto fromReviewEntity(ReviewEntity reviewEntity) {
        return ReviewDto.builder()
                .id(reviewEntity.getId())
                .rating(reviewEntity.getRating())
                .comment(reviewEntity.getComment())
                .createdAt(reviewEntity.getCreatedAt())
                .userId(reviewEntity.getUserDetails().getId())
                .productId(reviewEntity.getProductDetails().getId())
                .build();
    }
}
