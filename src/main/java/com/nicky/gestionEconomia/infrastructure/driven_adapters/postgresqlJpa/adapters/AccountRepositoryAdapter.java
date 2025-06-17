package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.AccountGateway;
import com.nicky.gestionEconomia.domain.models.AccountDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Repository
public class AccountRepositoryAdapter implements AccountGateway {

    private final AccountRepository accountRepository;

    @Override
    public AccountDomain createAccount(Long userId, AccountDomain account) {
        return null;
    }

    @Override
    public AccountDomain editAccount(Long accountId, AccountDomain account) {
        return null;
    }

    @Override
    public String deleteAccount(Long accountId) {
        return "";
    }

    @Override
    public String setTransactionToAccount(Long accountId, List<Long> transactionsIds) {
        return "";
    }
}
