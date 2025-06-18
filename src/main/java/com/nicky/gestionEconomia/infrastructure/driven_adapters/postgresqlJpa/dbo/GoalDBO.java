package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;


import com.nicky.gestionEconomia.domain.models.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "goal_TABLE")
public class GoalDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long currentAmount;
    private Long goalAmount;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private GoalState state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<TransactionDBO> transactions;

    public static GoalDBO fromDomain(GoalDomain domain){
        GoalDBO.GoalDBOBuilder builder = GoalDBO.builder()
                .id(domain.id())
                .name(domain.name())
                .currentAmount(domain.currentAmount())
                .goalAmount(domain.goalAmount())
                .dueDate(domain.dueDate())
                .state(domain.state());

        if(domain.user() != null){
            builder.user(UserDBO.builder().id(domain.user().id()).build());
        }

        if(domain.transactions() != null){
            builder.transactions(
                    domain.transactions().stream()
                            .map(transactionDomain -> TransactionDBO.builder()
                                    .id(transactionDomain.id())
                                    .date(transactionDomain.date())
                                    .amount(transactionDomain.amount())
                                    .description(transactionDomain.description())
                                    .build())
                            .toList()
            );
        }

        return builder.build();
    }

    public GoalDomain toDomain(){
        return new GoalDomain(
                id,
                name,
                getCurrentAmount(),
                getGoalAmount(),
                dueDate,
                state,
                user != null ? new UserDomain(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getDate(),
                        null,
                        null,
                        null,
                        null
                ) : null,
                transactions != null ? transactions.stream()
                        .map(transactionDBO -> new TransactionDomain(
                                transactionDBO.getId(),
                                transactionDBO.getDate(),
                                transactionDBO.getAmount(),
                                transactionDBO.getDescription(),
                                transactionDBO.getUser() != null ? new UserDomain(
                                        transactionDBO.getUser().getId(),
                                        transactionDBO.getUser().getName(),
                                        transactionDBO.getUser().getEmail(),
                                        transactionDBO.getUser().getPassword(),
                                        transactionDBO.getUser().getDate(),
                                        null,
                                        null,
                                        null,
                                        null
                                ) : null,
                                transactionDBO.getCategory() != null ? new CategoryDomain(
                                        transactionDBO.getCategory().getId(),
                                        transactionDBO.getCategory().getName(),
                                        transactionDBO.getCategory().getType(),
                                        null,
                                        null
                                ) : null,
                                transactionDBO.getAccount() != null ? new AccountDomain(
                                        transactionDBO.getAccount().getId(),
                                        transactionDBO.getAccount().getName(),
                                        transactionDBO.getAccount().getType(),
                                        transactionDBO.getAccount().getCurrentAmount(),
                                        transactionDBO.getAccount().getActive(),
                                        null,
                                        null
                                ) : null,
                                null
                        )).toList() : null
        );
    }
}
