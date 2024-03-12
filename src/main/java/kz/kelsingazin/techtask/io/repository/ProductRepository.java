package kz.kelsingazin.techtask.io.repository;

import kz.kelsingazin.techtask.io.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
