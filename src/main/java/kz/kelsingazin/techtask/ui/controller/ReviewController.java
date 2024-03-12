package kz.kelsingazin.techtask.ui.controller;

import kz.kelsingazin.techtask.service.ReviewService;
import kz.kelsingazin.techtask.shared.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }

    @PatchMapping("/{reviewId}")
    public ReviewDto updateReview(@PathVariable Long reviewId,
                                  @RequestParam String comment) {
        return reviewService.updateReview(reviewId, comment);
    }

    @GetMapping("/users/{userId}")
    public List<ReviewDto> getAllReviews(@PathVariable Long userId) {
        return reviewService.getAllUserReviews(userId);
    }
}
