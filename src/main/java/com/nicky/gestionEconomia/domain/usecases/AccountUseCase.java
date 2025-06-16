package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.AccountGateway;
import com.nicky.gestionEconomia.domain.models.AccountDomain;

import java.util.List;

public class AccountUseCase {

    private final AccountGateway accountGateway;

    public AccountUseCase(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    public AccountDomain createAccount(Long userId, AccountDomain account) {
        return accountGateway.createAccount(userId, account);
    }

    public AccountDomain editAccount(Long accountId, AccountDomain account) {
        return accountGateway.editAccount(accountId, account);
    }

    public String deleteAccount(Long accountId) {
        return accountGateway.deleteAccount(accountId);
    }

    public String setTransactionToAccount(Long accountId, List<Long> transactionsIds) {
        return accountGateway.setTransactionToAccount(accountId, transactionsIds);
    }
}
