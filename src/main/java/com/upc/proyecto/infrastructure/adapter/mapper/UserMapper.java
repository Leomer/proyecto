package com.upc.proyecto.infrastructure.adapter.mapper;


import com.upc.proyecto.domain.model.User;
import com.upc.proyecto.infrastructure.adapter.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity entity) {
        return new User(
                entity.getUserId(),
                entity.getName(),
                entity.getPaternalSurname(),
                entity.getMaternalSurname(),
                entity.getDni(),
                entity.getEmail()
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.userId(),
                user.name(),
                user.maternalSurname(),
                user.paternalSurname(),
                user.dni(),
                user.email()
        );
    }
}
