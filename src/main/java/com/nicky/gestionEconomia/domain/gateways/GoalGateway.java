package com.nicky.gestionEconomia.domain.gateways;

import com.nicky.gestionEconomia.domain.models.GoalDomain;

import java.util.List;

public interface GoalGateway {
    GoalDomain createGoal(Long userId, GoalDomain goal);
    GoalDomain setTransactionsToGoal(Long goalId, List<Long> transactionsId);
    String getProgress(Long goalId);
}
