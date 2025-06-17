package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories;

import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.AccountDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDBO, Long> {
}
