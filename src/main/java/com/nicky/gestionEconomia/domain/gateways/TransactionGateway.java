package com.nicky.gestionEconomia.domain.gateways;

import com.nicky.gestionEconomia.domain.models.TransactionDomain;

import java.util.List;

public interface TransactionGateway {

    List<TransactionDomain> getTransactions(Long userId);
    List<TransactionDomain> getBalance(Long userId);

    TransactionDomain createTransaction(Long accountId, TransactionDomain transaction);
    TransactionDomain editTransaction(Long transactionId, TransactionDomain transaction);
    String deleteTransaction(Long transactionId);
}
