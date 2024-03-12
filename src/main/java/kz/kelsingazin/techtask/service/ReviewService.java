package kz.kelsingazin.techtask.service;

import kz.kelsingazin.techtask.shared.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto createReview(ReviewDto reviewDto);

    ReviewDto updateReview(Long reviewId, String comment);

    List<ReviewDto> getAllUserReviews(Long userId);
}
