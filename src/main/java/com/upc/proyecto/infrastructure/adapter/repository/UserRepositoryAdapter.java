package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.domain.port.out.UserRepositoryPort;
import com.upc.proyecto.infrastructure.adapter.entity.UserEntity;
import com.upc.proyecto.infrastructure.adapter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findFirstByDniOrEmail(String dni, String email) {
        Optional<UserEntity> userEntity = jpaUserRepository.findFirstByDniOrEmail(dni, email);
        return userEntity.map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUserEntity = jpaUserRepository.save(userEntity);
        return userMapper.toDomain(savedUserEntity);
    }
}
