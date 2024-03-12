package kz.kelsingazin.techtask.ui.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReviewRequest {

    private Double rating;
    private String comment;
    private BigDecimal price;
    private Long userId;
    private Long productId;
}
