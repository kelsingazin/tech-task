package kz.kelsingazin.techtask.service.impl;

import kz.kelsingazin.techtask.io.entity.UserEntity;
import kz.kelsingazin.techtask.io.repository.UserRepository;
import kz.kelsingazin.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return optionalUserEntity.orElse(null);
    }
}
