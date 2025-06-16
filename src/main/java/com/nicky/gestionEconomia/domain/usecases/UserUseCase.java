package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.UserGateway;
import com.nicky.gestionEconomia.domain.models.UserDomain;

public class UserUseCase {

    private final UserGateway userGateway;

    public UserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public UserDomain register(UserDomain user) {
        return userGateway.register(user);
    }

    public String login(UserDomain user) {
        return userGateway.login(user);
    }
}
