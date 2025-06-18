package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.GoalGateway;
import com.nicky.gestionEconomia.domain.models.GoalDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.GoalDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.UserDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.GoalRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Repository
public class GoalRepositoryAdapter implements GoalGateway {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    @Override
    public GoalDomain createGoal(Long userId, GoalDomain goal) {

        UserDBO userFounded = findUserOrThrow(userId);
        GoalDBO goalMapped = GoalDBO.fromDomain(goal);
        goalMapped.setUser(userFounded);
        GoalDBO saved = goalRepository.save(goalMapped);

        return saved.toDomain();
    }

    // TODO
    @Override
    public GoalDomain setTransactionsToGoal(Long goalId, List<Long> transactionsId) {
        return null;
    }

    // TODO
    @Override
    public String getProgress(Long goalId) {
        GoalDBO goalFounded = findGoalOrThrow(goalId);

        long progress = goalFounded.getGoalAmount() - goalFounded.getCurrentAmount();
        return "Your progress is + " + progress;
    }

    // Solid
    private UserDBO findUserOrThrow(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    private GoalDBO findGoalOrThrow(Long goalId){
        return goalRepository.findById(goalId)
                .orElseThrow(() -> new NoSuchElementException("Goal not found"));
    }
}
