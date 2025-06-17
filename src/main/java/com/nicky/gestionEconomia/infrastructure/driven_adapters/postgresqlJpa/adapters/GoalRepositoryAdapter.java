package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.GoalGateway;
import com.nicky.gestionEconomia.domain.models.GoalDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Repository
public class GoalRepositoryAdapter implements GoalGateway {

    private final GoalRepository goalRepository;

    @Override
    public GoalDomain createGoal(Long userId, GoalDomain goal) {
        return null;
    }

    @Override
    public GoalDomain setTransactionsToGoal(Long goalId, List<Long> transactionsId) {
        return null;
    }

    @Override
    public String getProgress(Long goalId) {
        return "";
    }
}
