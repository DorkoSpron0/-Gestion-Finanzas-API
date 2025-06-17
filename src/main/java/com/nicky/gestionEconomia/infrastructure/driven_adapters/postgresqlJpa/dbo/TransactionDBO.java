package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.TransactionDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "transaction_TABLE")
public class TransactionDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Long amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDBO category;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountDBO account;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private GoalDBO goal;
}
