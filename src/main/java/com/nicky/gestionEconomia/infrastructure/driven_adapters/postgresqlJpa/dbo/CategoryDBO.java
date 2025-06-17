package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.*;
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
@Table(name = "category_TABLE")
public class CategoryDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO user;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<TransactionDBO> transactions;

    public static CategoryDBO fromDomain(CategoryDomain domain){
        CategoryDBO.CategoryDBOBuilder builder = CategoryDBO.builder()
                .id(domain.id())
                .name(domain.name())
                .type(domain.type());

        if(domain.user() != null) {
            builder.user(
                    new UserDBO(domain.user().id(), null, null, null, null, null, null, null, null)
            );
        }

        if(domain.transactions() != null){
            builder.transactions(
                    domain.transactions().stream()
                            .map(transactionDomain -> new TransactionDBO(
                                    transactionDomain.id(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                            )).toList()
            );
        }

        return builder.build();
    }

    public CategoryDomain toDomain(){
        return new CategoryDomain(
                id,
                name,
                type,
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
                                transactionDBO.getGoal() != null ? new GoalDomain(
                                        transactionDBO.getGoal().getId(),
                                        transactionDBO.getGoal().getName(),
                                        transactionDBO.getGoal().getGoalAmount(),
                                        transactionDBO.getGoal().getDueDate(),
                                        transactionDBO.getGoal().getState(),
                                        null,
                                        null
                                ) : null
                        )).toList() : null
        );
    }
}
