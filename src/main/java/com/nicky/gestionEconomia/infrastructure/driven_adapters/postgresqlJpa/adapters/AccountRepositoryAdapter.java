package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.AccountGateway;
import com.nicky.gestionEconomia.domain.models.AccountDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRepositoryAdapter implements AccountGateway {
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
