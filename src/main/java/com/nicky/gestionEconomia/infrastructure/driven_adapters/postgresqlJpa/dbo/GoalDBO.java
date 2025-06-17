package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;


import com.nicky.gestionEconomia.domain.models.GoalState;
import com.nicky.gestionEconomia.domain.models.UserDomain;
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
@Table(name = "goal_TABLE")
public class GoalDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long goalAmount;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private GoalState state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<TransactionDBO> transactions;
}
