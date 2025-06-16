package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.GoalGateway;
import com.nicky.gestionEconomia.domain.models.GoalDomain;

import java.util.List;

public class GoalUseCase {

    private final GoalGateway goalGateway;

    public GoalUseCase(GoalGateway goalGateway) {
        this.goalGateway = goalGateway;
    }

    public GoalDomain createGoal(Long userId, GoalDomain goal) {
        return goalGateway.createGoal(userId, goal);
    }

    public GoalDomain setTransactionsToGoal(Long goalId, List<Long> transactionsId) {
        return goalGateway.setTransactionsToGoal(goalId, transactionsId);
    }

    public String getProgress(Long goalId) {
        return goalGateway.getProgress(goalId);
    }
}
