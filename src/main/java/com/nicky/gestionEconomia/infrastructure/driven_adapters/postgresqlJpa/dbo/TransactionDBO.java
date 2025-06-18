package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "transaction_TABLE")
public class TransactionDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Long amount;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryDBO category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountDBO account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private GoalDBO goal;

    public static TransactionDBO fromDomain(TransactionDomain domain){
        TransactionDBO.TransactionDBOBuilder builder = TransactionDBO.builder()
                .id(domain.id())
                .date(domain.date())
                .amount(domain.amount())
                .description(domain.description());

        if(domain.user() != null){
            builder.user(
                    UserDBO.builder()
                            .id(domain.user().id())
                            .build()
            );
        }

        if(domain.category() != null){
            builder.category(
                    CategoryDBO.builder()
                            .id(domain.category().id())
                            .build()
            );
        }

        if(domain.account() != null){
            builder.account(
                    AccountDBO.builder()
                            .id(domain.account().id())
                            .build()
            );
        }

        if(domain.goal() != null){
            builder.goal(
                    GoalDBO.builder()
                            .id(domain.goal().id())
                            .build()
            );
        }

        return builder.build();
    }

    public TransactionDomain toDomain(){
        return new TransactionDomain(
                id,
                date,
                amount,
                description,
                user != null
                        ?  new UserDomain(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getDate(),
                        null,
                        null,
                        null,
                        null
                )
                        : null,
                category != null
                        ? new CategoryDomain(
                        category.getId(),
                        category.getName(),
                        category.getType(),
                        null,
                        null
                )
                        : null,
                account != null ? new AccountDomain(
                        account.getId(),
                        account.getName(),
                        account.getType(),
                        account.getCurrentAmount(),
                        account.getActive(),
                        null,
                        null) : null,
                goal != null
                        ? new GoalDomain(
                        goal.getId(),
                        goal.getName(),
                        goal.getCurrentAmount(),
                        goal.getGoalAmount(),
                        goal.getDueDate(),
                        goal.getState(),
                        null,
                        null
                )
                        : null
        );
    }
}
