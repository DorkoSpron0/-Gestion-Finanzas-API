package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.TransactionGateway;
import com.nicky.gestionEconomia.domain.models.TransactionDomain;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionUseCase {

    private final TransactionGateway transactionGateway;

    public TransactionUseCase(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public List<TransactionDomain> getTransactions(Long accountId) {
        return transactionGateway.getTransactions(accountId);
    }

    public List<TransactionDomain> getBalance(Long userId) {
        return transactionGateway.getBalance(userId);
    }

    public TransactionDomain createTransaction(Long accountId, String categoryName, String goalName,TransactionDomain transaction) {
        System.out.println("Creating transaction");

        if(transaction.amount() <= 0){
            throw new IllegalArgumentException("Amount should be Greater than 0");
        }

        TransactionDomain transactionToSave = new TransactionDomain(
                transaction.id() != null ? transaction.id() : null,
                LocalDateTime.now(),
                transaction.amount(),
                transaction.description() != null ? transaction.description() : "",
                transaction.user()  != null ? transaction.user() : null,
                transaction.category() != null ? transaction.category() : null,
                transaction.account()  != null ? transaction.account() : null,
                transaction.goal()  != null ? transaction.goal() : null
        );
        return transactionGateway.createTransaction(accountId, categoryName, goalName,transactionToSave);
    }

    public TransactionDomain editTransaction(Long transactionId, TransactionDomain transaction) {
        return transactionGateway.editTransaction(transactionId, transaction);
    }

    public String deleteTransaction(Long transactionId) {
        return transactionGateway.deleteTransaction(transactionId);
    }
}
