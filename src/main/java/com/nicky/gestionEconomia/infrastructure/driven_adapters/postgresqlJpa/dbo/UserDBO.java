package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public static UserDBO fromDomain(UserDomain domain) {
        UserDBO.UserDBOBuilder builder = UserDBO.builder()
                .id(domain.id())
                .name(domain.name())
                .email(domain.email())
                .password(domain.password())
                .date(domain.date());

        if (domain.accounts() != null) {
            builder.accounts(
                    domain.accounts().stream()
                            .map(accountDomain -> new AccountDBO(
                                    accountDomain.id(),
                                    accountDomain.name(),
                                    accountDomain.type(),
                                    accountDomain.currentAmount(),
                                    accountDomain.active(),
                                    null,
                                    null
                            )).toList()
            );
        }

        if(domain.transactions() != null){
            builder.transactions(
                    domain.transactions().stream()
                            .map(transactionDomain -> new TransactionDBO(
                                    transactionDomain.id(),
                                    transactionDomain.date(),
                                    transactionDomain.amount(),
                                    transactionDomain.description(),
                                    null,
                                    null,
                                    null,
                                    null
                            )).toList()
            );
        }

        if(domain.categories() != null){
            builder.categories(
                    domain.categories().stream()
                            .map(categoryDomain -> new CategoryDBO(
                                    categoryDomain.id(),
                                    categoryDomain.name(),
                                    categoryDomain.type(),
                                    null,
                                    null
                            )).toList()
            );
        }

        if(domain.goals() != null ){
            builder.goals(
                    domain.goals().stream()
                            .map(goalDomain -> new GoalDBO(
                                    goalDomain.id(),
                                    goalDomain.name(),
                                    goalDomain.goalAmount(),
                                    goalDomain.dueDate(),
                                    goalDomain.state(),
                                    null,
                                    null
                            )).toList()
            );
        }

        return builder.build();
    }

    public UserDomain toDomain(){
        return new UserDomain(
                id,
                name,
                email,
                password,
                date,

                accounts != null ? accounts.stream()
                        .map(accountDBO -> new AccountDomain(
                                accountDBO.getId(),
                                accountDBO.getName(),
                                accountDBO.getType(),
                                accountDBO.getCurrentAmount(),
                                accountDBO.getActive(),
                                null,
                                null
                        )).toList() : null,
                transactions != null ? transactions.stream()
                        .map(transactionDBO -> new TransactionDomain(
                                transactionDBO.getId(),
                                transactionDBO.getDate(),
                                transactionDBO.getAmount(),
                                transactionDBO.getDescription(),
                                null,
                                null,
                                null,
                                null
                        )).toList() : null,
                categories != null ? categories.stream()
                        .map(categoryDBO -> new CategoryDomain(
                                categoryDBO.getId(),
                                categoryDBO.getName(),
                                categoryDBO.getType(),
                                null,
                                null
                        )).toList() : null,
                goals != null ? goals.stream()
                        .map(goalDBO -> new GoalDomain(
                                goalDBO.getId(),
                                goalDBO.getName(),
                                goalDBO.getGoalAmount(),
                                goalDBO.getDueDate(),
                                goalDBO.getState(),
                                null,
                                null
                        )).toList() : null
        );
    }
}
