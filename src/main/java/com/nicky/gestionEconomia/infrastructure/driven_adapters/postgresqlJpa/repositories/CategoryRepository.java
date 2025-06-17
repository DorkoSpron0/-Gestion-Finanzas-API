package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories;

import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.CategoryDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryDBO, Long> {
}
