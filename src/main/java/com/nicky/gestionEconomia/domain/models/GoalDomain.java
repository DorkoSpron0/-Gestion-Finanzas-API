package com.nicky.gestionEconomia.domain.models;

import java.time.LocalDate;
import java.util.List;

public record GoalDomain(Long id,
                         String name,
                         Long goalAmount,
                         LocalDate dueDate,
                         GoalState state,
                         UserDomain user,
                         List<TransactionDomain> transactions) {
}
