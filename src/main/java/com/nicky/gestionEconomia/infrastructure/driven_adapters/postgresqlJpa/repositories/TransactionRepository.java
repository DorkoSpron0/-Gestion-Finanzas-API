package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories;

import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.TransactionDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionDBO, Long> {
}
