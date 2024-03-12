package kz.kelsingazin.techtask.io.repository;

import jakarta.transaction.Transactional;
import kz.kelsingazin.techtask.io.entity.ReviewEntity;
import kz.kelsingazin.techtask.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE ReviewEntity r SET r.comment = :comment WHERE r.id = :reviewId")
    void updateReviewComment(@Param("reviewId") Long reviewId,
                             @Param("comment") String comment);

    List<ReviewEntity> findAllByUserDetails(UserEntity userDetails);
}
