package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    public static AccountDBO fromDomain(AccountDomain domain){
        AccountDBO.AccountDBOBuilder builder = AccountDBO.builder()
                .id(domain.id())
                .name(domain.name())
                .type(domain.type())
                .currentAmount(domain.currentAmount())
                .active(domain.active());

                if(domain.user() != null){
                    builder.user(UserDBO.builder().id(domain.user().id()).build());
                }

                if (domain.transactions() != null) {
                    builder.transactions(domain.transactions().stream()
                            .map(transactionDomain -> TransactionDBO.builder()
                                    .id(transactionDomain.id())
                                    .date(transactionDomain.date())
                                    .amount(transactionDomain.amount())
                                    .description(transactionDomain.description())
                                    .build())
                            .toList());
                }

                return builder.build();
    }

    public AccountDomain toDomain(){
        return new AccountDomain(
                id,
                name,
                type,
                currentAmount,
                active,
                new UserDomain(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getDate(),
                        null,
                        null,
                        null,
                        null
                ),
                transactions != null ? transactions.stream().map(
                        transactionDBO -> new TransactionDomain(
                                transactionDBO.getId(),
                                transactionDBO.getDate(),
                                transactionDBO.getAmount(),
                                transactionDBO.getDescription(),
                                new UserDomain(
                                        transactionDBO.getUser().getId(),
                                        transactionDBO.getUser().getName(),
                                        transactionDBO.getUser().getEmail(),
                                        transactionDBO.getUser().getPassword(),
                                        transactionDBO.getUser().getDate(),
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                transactionDBO.getCategory() != null ? new CategoryDomain(
                                        transactionDBO.getCategory().getId(),
                                        transactionDBO.getCategory().getName(),
                                        transactionDBO.getCategory().getType(),
                                        null,
                                        null
                                ) : null,
                                new AccountDomain(
                                        transactionDBO.getAccount().getId(),
                                        transactionDBO.getAccount().getName(),
                                        transactionDBO.getAccount().getType(),
                                        transactionDBO.getAccount().getCurrentAmount(),
                                        transactionDBO.getAccount().getActive(),
                                        null,
                                        null
                                ),
                                transactionDBO.getGoal() != null ? new GoalDomain(
                                        transactionDBO.getGoal().getId(),
                                        transactionDBO.getGoal().getName(),
                                        transactionDBO.getGoal().getGoalAmount(),
                                        transactionDBO.getGoal().getDueDate(),
                                        transactionDBO.getGoal().getState(),
                                        null,
                                        null
                                ) : null
                        )
                ).toList() : new ArrayList<>()
        );
    }
}
