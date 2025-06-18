package com.nicky.gestionEconomia.infrastructure.entry_points;

import com.nicky.gestionEconomia.domain.models.GoalDomain;
import com.nicky.gestionEconomia.domain.usecases.GoalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/goal")
public class GoalController {

    private final GoalUseCase goalUseCase;

    @PostMapping("/{userId}")
    public ResponseEntity<GoalDomain> createGoal(@PathVariable Long userId, @RequestBody GoalDomain goal){
        return ResponseEntity.status(HttpStatus.CREATED).body(goalUseCase.createGoal(userId, goal));
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<String> getProgress(@PathVariable Long goalId){
        return ResponseEntity.status(HttpStatus.OK).body(goalUseCase.getProgress(goalId));
    }

}
