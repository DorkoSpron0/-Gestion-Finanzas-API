package com.nicky.gestionEconomia.domain.models;

import java.util.List;

public record CategoryDomain(Long id,
                             String name,
                             String type,
                             UserDomain user,
                             List<TransactionDomain> transactions) {
}
