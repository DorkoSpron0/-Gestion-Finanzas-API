package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.UserGateway;
import com.nicky.gestionEconomia.domain.models.UserDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.UserDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor

@Repository
public class UserRepositoryAdapter implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public UserDomain register(UserDomain user) {
        UserDBO userMapped = UserDBO.fromDomain(user);
        UserDBO saved = userRepository.save(userMapped);
        return saved.toDomain();
    }

    @Override
    public String login(UserDomain user) {
        return "Jwt Token :D";
    }
}
