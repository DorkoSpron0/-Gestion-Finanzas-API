package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.CategoryGateway;
import com.nicky.gestionEconomia.domain.models.CategoryDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryRepositoryAdapter implements CategoryGateway {
    @Override
    public List<CategoryDomain> getCategories(Long userId) {
        return List.of();
    }

    @Override
    public CategoryDomain createCategory(Long userId, CategoryDomain category) {
        return null;
    }

    @Override
    public CategoryDomain editCategory(Long categoryId, CategoryDomain category) {
        return null;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        return "";
    }
}
