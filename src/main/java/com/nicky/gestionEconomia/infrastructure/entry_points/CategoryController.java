package com.nicky.gestionEconomia.infrastructure.entry_points;

import com.nicky.gestionEconomia.domain.models.CategoryDomain;
import com.nicky.gestionEconomia.domain.usecases.CategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryUseCase categoryUseCase;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CategoryDomain>> getCategories(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(categoryUseCase.getCategories(userId));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CategoryDomain> createCategory(@PathVariable Long userId, @RequestBody CategoryDomain category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryUseCase.createCategory(userId, category));
    }
}
