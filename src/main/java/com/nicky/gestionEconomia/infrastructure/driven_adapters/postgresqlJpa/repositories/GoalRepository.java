package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories;

import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.GoalDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalDBO, Long> {
}
