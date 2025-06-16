package com.nicky.gestionEconomia.domain.models;

import java.time.LocalDateTime;

public record TransactionDomain(Long id,
                                LocalDateTime date,
                                Long amount,
                                String description,
                                UserDomain user,
                                CategoryDomain category,
                                AccountDomain account,
                                GoalDomain goal) {
}
