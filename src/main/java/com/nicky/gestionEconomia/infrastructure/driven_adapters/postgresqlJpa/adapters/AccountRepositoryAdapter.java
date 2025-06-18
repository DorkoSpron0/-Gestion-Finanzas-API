package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.AccountGateway;
import com.nicky.gestionEconomia.domain.models.AccountDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.AccountDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.UserDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.AccountRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Repository
public class AccountRepositoryAdapter implements AccountGateway {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountDomain createAccount(Long userId, AccountDomain account) {
        UserDBO userFounded = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        AccountDBO accountMapped = AccountDBO.fromDomain(account);
        accountMapped.setUser(userFounded);
        AccountDBO saved = accountRepository.save(accountMapped);
        return saved.toDomain();
    }

    // TODO
    @Override
    public AccountDomain editAccount(Long accountId, AccountDomain account) {
        return null;
    }

    @Override
    public String deleteAccount(Long accountId) {
        AccountDBO accountFounded = accountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("Account not found"));

        accountRepository.delete(accountFounded);
        return "Account with id " + accountId + " not found";
    }

    // TODO
    @Override
    public String setTransactionToAccount(Long accountId, List<Long> transactionsIds) {
        return "";
    }
}
