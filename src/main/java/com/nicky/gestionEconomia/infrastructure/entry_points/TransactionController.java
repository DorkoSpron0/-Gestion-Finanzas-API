package com.nicky.gestionEconomia.infrastructure.entry_points;

import com.nicky.gestionEconomia.domain.models.TransactionDomain;
import com.nicky.gestionEconomia.domain.models.UserDomain;
import com.nicky.gestionEconomia.domain.usecases.TransactionUseCase;
import com.nicky.gestionEconomia.infrastructure.entry_points.dto.request.TransactionRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionDomain>> getTransactions(@PathVariable Long accountId){
        return ResponseEntity.status(HttpStatus.OK).body(transactionUseCase.getTransactions(accountId));
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<TransactionDomain> createTransaction(@PathVariable Long accountId, @RequestBody TransactionRequestDto transaction){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionUseCase.createTransaction(accountId, transaction.categoryName(),
                transaction.goalName(),
                dtoToDomain(transaction)));
    }

    private TransactionDomain dtoToDomain(TransactionRequestDto dto){
        return new TransactionDomain(
                null,
                LocalDateTime.now(),
                dto.amount(),
                dto.description(),
                null,
                null,
                null,
                null
        );
    }
}
