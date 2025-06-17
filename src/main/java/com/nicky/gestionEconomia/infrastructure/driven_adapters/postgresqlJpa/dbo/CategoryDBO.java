package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo;

import com.nicky.gestionEconomia.domain.models.TransactionDomain;
import com.nicky.gestionEconomia.domain.models.UserDomain;
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
}
