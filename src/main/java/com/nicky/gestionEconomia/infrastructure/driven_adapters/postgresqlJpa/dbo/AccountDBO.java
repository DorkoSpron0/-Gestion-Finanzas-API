package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "account_TABLE")
public class AccountDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long currentAmount;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<TransactionDBO> transactions;
}
