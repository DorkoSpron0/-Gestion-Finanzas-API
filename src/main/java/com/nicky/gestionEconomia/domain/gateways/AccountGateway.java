package com.nicky.gestionEconomia.domain.gateways;

import com.nicky.gestionEconomia.domain.models.AccountDomain;

import java.util.List;

public interface AccountGateway {
    AccountDomain createAccount(Long userId, AccountDomain account);
    AccountDomain editAccount(Long accountId, AccountDomain account);
    String deleteAccount(Long accountId);
    String setTransactionToAccount(Long accountId, List<Long> transactionsIds);
}
