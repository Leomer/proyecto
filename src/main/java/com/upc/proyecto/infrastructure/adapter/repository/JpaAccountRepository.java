package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.infrastructure.adapter.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity,String> {
    Optional<AccountEntity> findByDni(String dni);
}
