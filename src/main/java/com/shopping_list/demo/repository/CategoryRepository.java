package com.shopping_list.demo.repository;

import com.shopping_list.demo.models.entities.Category;
import com.shopping_list.demo.models.entities.CategoryEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategoryEnumName categoryEnumName);
}
