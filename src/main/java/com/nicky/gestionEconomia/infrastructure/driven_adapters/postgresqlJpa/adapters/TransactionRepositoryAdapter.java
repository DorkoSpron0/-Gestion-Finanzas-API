package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.TransactionGateway;
import com.nicky.gestionEconomia.domain.models.TransactionDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.AccountDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.CategoryDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.GoalDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.TransactionDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.AccountRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.CategoryRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.GoalRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Repository
public class TransactionRepositoryAdapter implements TransactionGateway {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    private final GoalRepository goalRepository;

    @Override
    public List<TransactionDomain> getTransactions(Long accountId) {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.getAccount().getId().equals(accountId))
                .map(TransactionDBO::toDomain)
                .toList();
    }

    // TODO
    @Override
    public List<TransactionDomain> getBalance(Long userId) {
        return List.of();
    }

    // TODO -> Refactor
    @Override
    public TransactionDomain createTransaction(Long accountId, String categoryName, String goalName, TransactionDomain transaction) {

        AccountDBO accountFounded = findAccountOrThrow(accountId);

        TransactionDBO transactionMapped = TransactionDBO.fromDomain(transaction);

        transactionMapped.setAccount(accountFounded);
        transactionMapped.setUser(accountFounded.getUser());

        if(categoryName != null){
            CategoryDBO categoryFounded = findCategoryOrThrow(categoryName);
            transactionMapped.setCategory(categoryFounded);
        }

        if(goalName != null){
            GoalDBO goalFounded = findGoalOrThrow(goalName);
            goalFounded.setCurrentAmount(goalFounded.getCurrentAmount() + transactionMapped.getAmount());
            transactionMapped.setGoal(goalFounded);
        }

        TransactionDBO saved = saveTransaction(transactionMapped);

        return saved.toDomain();
    }

    // TODO|
    @Override
    public TransactionDomain editTransaction(Long transactionId, TransactionDomain transaction) {
        return null;
    }

    @Override
    public String deleteTransaction(Long transactionId) {
        TransactionDBO transactionFounded = findTransactionOrThrow(transactionId);
        transactionRepository.delete(transactionFounded);
        return "Transaction with id " + transactionId + " deleted successfully";
    }

    // SOLID
    private AccountDBO findAccountOrThrow(Long accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("Account not found"));
    }

    private CategoryDBO findCategoryOrThrow(String categoryName){
        return categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
    }

    private GoalDBO findGoalOrThrow(String goalName){
        return goalRepository.findByName(goalName)
                .orElseThrow(() -> new NoSuchElementException("Goal not found"));
    }

    private TransactionDBO findTransactionOrThrow(Long transactionId){
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found"));
    }

    private TransactionDBO saveTransaction(TransactionDBO transaction){
        return transactionRepository.save(transaction);
    }
}
