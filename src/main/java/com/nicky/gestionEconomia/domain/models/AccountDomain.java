package com.nicky.gestionEconomia.domain.models;

import java.util.List;

public record AccountDomain(Long id,
                            String name,
                            AccountType type,
                            Long currentAmount,
                            Boolean active,
                            UserDomain user,
                            List<TransactionDomain> transactions) {
}
