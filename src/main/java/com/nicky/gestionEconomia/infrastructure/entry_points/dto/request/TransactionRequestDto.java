package com.nicky.gestionEconomia.infrastructure.entry_points.dto.request;

import lombok.Builder;

@Builder
public record TransactionRequestDto(Long amount,
                                    String description,
                                    String categoryName,
                                    String goalName) {
}
