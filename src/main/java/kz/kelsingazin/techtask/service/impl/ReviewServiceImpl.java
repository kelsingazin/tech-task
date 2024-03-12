package kz.kelsingazin.techtask.service.impl;

import kz.kelsingazin.techtask.io.entity.ProductEntity;
import kz.kelsingazin.techtask.io.entity.ReviewEntity;
import kz.kelsingazin.techtask.io.entity.UserEntity;
import kz.kelsingazin.techtask.io.repository.ReviewRepository;
import kz.kelsingazin.techtask.service.ProductService;
import kz.kelsingazin.techtask.service.ReviewService;
import kz.kelsingazin.techtask.service.UserService;
import kz.kelsingazin.techtask.shared.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        UserEntity user = userService.findById(reviewDto.getUserId());
        ProductEntity product = productService.findById(reviewDto.getProductId());

        if (user == null || product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь или продукт не найден");
        }

        ReviewEntity review = ReviewEntity.fromReviewDto(reviewDto, user, product);

        review.setCreatedAt(new Date());
        ReviewEntity savedEntity = reviewRepository.save(review);

        return ReviewDto.fromReviewEntity(savedEntity);
    }

    @Override
    public ReviewDto updateReview(Long reviewId, String comment) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElse(null);

        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Такой отзыв не найден");
        }

        review.setComment(comment);
        review.setUpdatedAt(new Date());

        return ReviewDto.fromReviewEntity(reviewRepository.save(review));
    }

    @Override
    public List<ReviewDto> getAllUserReviews(Long userId) {
        UserEntity user = userService.findById(userId);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найден");
        }

        List<ReviewDto> allReviews = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewRepository.findAllByUserDetails(user)) {
            allReviews.add(ReviewDto.fromReviewEntity(reviewEntity));
        }

        return allReviews;
    }
}
