package kz.kelsingazin.techtask.service;

import kz.kelsingazin.techtask.io.entity.UserEntity;

public interface UserService {

    UserEntity findById(Long id);
}
