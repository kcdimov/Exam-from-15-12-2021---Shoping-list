package com.shopping_list.demo.services;

import com.shopping_list.demo.models.entities.CategoryEnumName;
import com.shopping_list.demo.models.service.ProductServiceModel;
import com.shopping_list.demo.models.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();
    List<ProductViewModel> findAllProductsByCategoryName(CategoryEnumName categoryEnumName);
    void buyById(Long id);
    void byAll();
}
