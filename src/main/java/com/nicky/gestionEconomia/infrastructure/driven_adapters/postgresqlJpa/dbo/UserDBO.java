package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "user_TABLE")
public class UserDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountDBO> accounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TransactionDBO> transactions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CategoryDBO> categories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoalDBO> goals;
}
