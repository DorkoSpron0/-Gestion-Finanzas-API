package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.UserGateway;
import com.nicky.gestionEconomia.domain.models.UserDomain;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryAdapter implements UserGateway {
    @Override
    public UserDomain register(UserDomain user) {
        return null;
    }

    @Override
    public String login(UserDomain user) {
        return "";
    }
}
