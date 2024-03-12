package kz.kelsingazin.techtask.service;

import kz.kelsingazin.techtask.io.entity.ProductEntity;

public interface ProductService {

    ProductEntity findById(Long id);
}
