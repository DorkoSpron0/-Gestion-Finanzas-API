package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.UserGateway;
import com.nicky.gestionEconomia.domain.models.UserDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor

@Repository
public class UserRepositoryAdapter implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public UserDomain register(UserDomain user) {
        return null;
    }

    @Override
    public String login(UserDomain user) {
        return "";
    }
}
