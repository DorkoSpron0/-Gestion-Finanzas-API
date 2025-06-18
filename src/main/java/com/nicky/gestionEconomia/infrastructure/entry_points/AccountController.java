package com.nicky.gestionEconomia.infrastructure.entry_points;

import com.nicky.gestionEconomia.domain.models.AccountDomain;
import com.nicky.gestionEconomia.domain.usecases.AccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    @PostMapping("/{accountId}")
    public ResponseEntity<AccountDomain> createAccount(@PathVariable Long accountId,
                                                       @RequestBody AccountDomain account){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountUseCase.createAccount(accountId, account));
    }
}
