package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.TransactionGateway;
import com.nicky.gestionEconomia.domain.models.TransactionDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Repository
public class TransactionRepositoryAdapter implements TransactionGateway {

    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionDomain> getTransactions(Long userId) {
        return List.of();
    }

    @Override
    public List<TransactionDomain> getBalance(Long userId) {
        return List.of();
    }

    @Override
    public TransactionDomain createTransaction(Long accountId, TransactionDomain transaction) {
        return null;
    }

    @Override
    public TransactionDomain editTransaction(Long transactionId, TransactionDomain transaction) {
        return null;
    }

    @Override
    public String deleteTransaction(Long transactionId) {
        return "";
    }
}
