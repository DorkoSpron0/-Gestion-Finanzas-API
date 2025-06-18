package com.nicky.gestionEconomia.infrastructure.entry_points.dto.response;

import com.nicky.gestionEconomia.domain.models.AccountDomain;
import com.nicky.gestionEconomia.domain.models.CategoryDomain;
import com.nicky.gestionEconomia.domain.models.GoalDomain;
import com.nicky.gestionEconomia.domain.models.UserDomain;

import java.time.LocalDateTime;

public record TransactionResponseDto(Long id,
                                     LocalDateTime date,
                                     Long amount,
                                     String description,
                                     UserDomain user,
                                     CategoryDomain category,
                                     AccountDomain account,
                                     GoalDomain goal) {
}
