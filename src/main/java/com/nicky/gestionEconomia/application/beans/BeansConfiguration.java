package com.nicky.gestionEconomia.application.beans;

import com.nicky.gestionEconomia.domain.gateways.*;
import com.nicky.gestionEconomia.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public UserUseCase userUseCase(UserGateway userGateway) {
        return new UserUseCase(userGateway);
    }

    @Bean
    public AccountUseCase accountUseCase(AccountGateway accountGateway) {
        return new AccountUseCase(accountGateway);
    }

    @Bean
    public TransactionUseCase transactionUseCase(TransactionGateway transactionGateway) {
        return new TransactionUseCase(transactionGateway);
    }

    @Bean
    public CategoryUseCase categoryUseCase(CategoryGateway categoryGateway) {
        return new CategoryUseCase(categoryGateway);
    }

    @Bean
    public GoalUseCase goalUseCase(GoalGateway goalGateway) {
        return new GoalUseCase(goalGateway);
    }
}
