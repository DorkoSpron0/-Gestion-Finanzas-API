package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.TransactionGateway;
import com.nicky.gestionEconomia.domain.models.TransactionDomain;

import java.util.List;

public class TransactionUseCase {

    private final TransactionGateway transactionGateway;

    public TransactionUseCase(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public List<TransactionDomain> getTransactions(Long userId) {
        return transactionGateway.getTransactions(userId);
    }

    public List<TransactionDomain> getBalance(Long userId) {
        return transactionGateway.getBalance(userId);
    }

    public TransactionDomain createTransaction(Long accountId, TransactionDomain transaction) {
        return transactionGateway.createTransaction(accountId, transaction);
    }

    public TransactionDomain editTransaction(Long transactionId, TransactionDomain transaction) {
        return transactionGateway.editTransaction(transactionId, transaction);
    }

    public String deleteTransaction(Long transactionId) {
        return transactionGateway.deleteTransaction(transactionId);
    }
}
