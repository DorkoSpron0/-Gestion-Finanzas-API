package com.nicky.gestionEconomia.domain.gateways;

import com.nicky.gestionEconomia.domain.models.UserDomain;

public interface UserGateway {
    UserDomain register(UserDomain user);
    String login(UserDomain user);
}
