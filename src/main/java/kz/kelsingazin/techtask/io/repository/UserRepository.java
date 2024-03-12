package kz.kelsingazin.techtask.io.repository;

import kz.kelsingazin.techtask.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
