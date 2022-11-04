package com.shopping_list.demo.services;

import com.shopping_list.demo.models.entities.Category;
import com.shopping_list.demo.models.entities.CategoryEnumName;

public interface CategoryService {
    void initCategory();

    Category findByName(CategoryEnumName categoryEnumName);

}
