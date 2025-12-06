package com.upc.proyecto.infrastructure.adapter.repository;

import com.upc.proyecto.domain.model.Account;
import com.upc.proyecto.domain.port.out.AccountRepositoryPort;
import com.upc.proyecto.infrastructure.adapter.entity.AccountEntity;
import com.upc.proyecto.infrastructure.adapter.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryPort {
    private final JpaAccountRepository jpaAccountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Optional<Account> findByDni(String dni) {
        Optional<AccountEntity> accountEntity = jpaAccountRepository.findByDni(dni);
        return accountEntity.map(accountMapper::toDomain);
    }
}
