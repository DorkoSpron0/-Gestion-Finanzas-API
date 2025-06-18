package com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.adapters;

import com.nicky.gestionEconomia.domain.gateways.CategoryGateway;
import com.nicky.gestionEconomia.domain.models.CategoryDomain;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.CategoryDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.dbo.UserDBO;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.CategoryRepository;
import com.nicky.gestionEconomia.infrastructure.driven_adapters.postgresqlJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Repository
public class CategoryRepositoryAdapter implements CategoryGateway {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public List<CategoryDomain> getCategories(Long userId) {
        return categoryRepository.findAll()
                .stream()
                .filter(categoryDBO -> categoryDBO.getUser().getId().equals(userId))
                .map(CategoryDBO::toDomain)
                .toList();
    }

    @Override
    public CategoryDomain createCategory(Long userId, CategoryDomain category) {
        UserDBO userFounded = findUserOrThrow(userId);
        CategoryDBO categoryMapped = CategoryDBO.fromDomain(category);
        categoryMapped.setUser(userFounded);

        CategoryDBO saved = saveCategory(categoryMapped);
        return saved.toDomain();
    }

    // TODO
    @Override
    public CategoryDomain editCategory(Long categoryId, CategoryDomain category) {
        return null;
    }

    // TODO
    @Override
    public String deleteCategory(Long categoryId) {
        return "";
    }

    private CategoryDBO saveCategory(CategoryDBO category){
        return categoryRepository.save(category);
    }

    private UserDBO findUserOrThrow(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}
