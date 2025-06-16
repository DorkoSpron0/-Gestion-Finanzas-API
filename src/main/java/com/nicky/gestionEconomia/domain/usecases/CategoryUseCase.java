package com.nicky.gestionEconomia.domain.usecases;

import com.nicky.gestionEconomia.domain.gateways.CategoryGateway;
import com.nicky.gestionEconomia.domain.models.CategoryDomain;

import java.util.List;

public class CategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<CategoryDomain> getCategories(Long userId) {
        return categoryGateway.getCategories(userId);
    }

    public CategoryDomain createCategory(Long userId, CategoryDomain category) {
        return categoryGateway.createCategory(userId, category);
    }

    public CategoryDomain editCategory(Long categoryId, CategoryDomain category) {
        return categoryGateway.editCategory(categoryId, category);
    }

    public String deleteCategory(Long categoryId) {
        return categoryGateway.deleteCategory(categoryId);
    }
}
