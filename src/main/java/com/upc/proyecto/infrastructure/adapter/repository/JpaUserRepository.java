package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.infrastructure.adapter.entity.AccountEntity;
import com.upc.proyecto.infrastructure.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findFirstByDniOrEmail(String dni, String email);
}
