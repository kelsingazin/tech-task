package kz.kelsingazin.techtask.service.impl;

import kz.kelsingazin.techtask.io.entity.ProductEntity;
import kz.kelsingazin.techtask.io.repository.ProductRepository;
import kz.kelsingazin.techtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity findById(Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        return optionalProductEntity.orElse(null);
    }
}
