package com.nicky.gestionEconomia.domain.gateways;

import com.nicky.gestionEconomia.domain.models.CategoryDomain;

import java.util.List;

public interface CategoryGateway {
    List<CategoryDomain> getCategories(Long userId);
    CategoryDomain createCategory(Long userId, CategoryDomain category);
    CategoryDomain editCategory(Long categoryId, CategoryDomain category);
    String deleteCategory(Long categoryId);
}
