package com.upc.proyecto.infrastructure.adapter.mapper;

import com.upc.proyecto.domain.model.Account;
import com.upc.proyecto.infrastructure.adapter.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toDomain(AccountEntity entity) {
        return new Account(
                entity.getAccountId(),
                entity.getDni(),
                entity.getPassword(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.isStatus()
        );
    }

    public AccountEntity toEntity(Account account) {
        return new AccountEntity(
                account.accountId(),
                account.dni(),
                account.password(),
                account.role(),
                account.createdAt(),
                account.status()
        );
    }
}
