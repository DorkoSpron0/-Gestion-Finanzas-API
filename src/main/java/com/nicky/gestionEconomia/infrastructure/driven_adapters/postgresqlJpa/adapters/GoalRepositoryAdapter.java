package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.GoalGateway;
import com.nicky.gestionEconomia.domain.models.GoalDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalRepositoryAdapter implements GoalGateway {
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
