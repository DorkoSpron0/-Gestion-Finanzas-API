package com.nicky.gestionEconomia.domain.models;

import java.time.LocalDate;
import java.util.List;

public record UserDomain(
        Long id,
        String name,
        String email,
        String password,
        LocalDate date,
        List<AccountDomain> accounts,
        List<TransactionDomain> transactions,
        List<CategoryDomain> categories,
        List<GoalDomain> goals) {

    public UserDomain(Long id) {
        this(id, null, null, null, null, null, null, null, null);
    }
}
