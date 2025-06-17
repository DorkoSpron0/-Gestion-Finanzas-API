package com.nicky.gestionEconomia.infrastructure.entry_points;

import com.nicky.gestionEconomia.domain.models.UserDomain;
import com.nicky.gestionEconomia.domain.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("/register")
    public ResponseEntity<UserDomain> registerUser(@RequestBody UserDomain user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCase.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDomain user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCase.login(user));
    }
}
