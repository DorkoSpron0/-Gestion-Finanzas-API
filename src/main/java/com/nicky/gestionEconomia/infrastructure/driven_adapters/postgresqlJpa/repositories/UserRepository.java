package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories;

import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDBO, Long> {
}
