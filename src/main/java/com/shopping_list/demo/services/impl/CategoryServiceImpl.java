package com.shopping_list.demo.services.impl;

import com.shopping_list.demo.models.entities.Category;
import com.shopping_list.demo.models.entities.CategoryEnumName;
import com.shopping_list.demo.repository.CategoryRepository;
import com.shopping_list.demo.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnumName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName, "details for " + categoryName.name());
                        categoryRepository.save(category);
                    });
        }

    }

    @Override
    public Category findByName(CategoryEnumName categoryEnumName) {
        return categoryRepository.findByName(categoryEnumName);
    }
}
