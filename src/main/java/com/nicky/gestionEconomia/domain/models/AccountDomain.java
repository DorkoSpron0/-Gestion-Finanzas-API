package com.nicky.gestionEconomia.domain.models;

public record AccountDomain(Long id,
                            String name,
                            AccountType type,
                            Long currentAmount,
                            Boolean active,
                            UserDomain user) {
}
