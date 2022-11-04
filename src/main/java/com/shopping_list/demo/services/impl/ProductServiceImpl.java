package com.shopping_list.demo.services.impl;

import com.shopping_list.demo.models.entities.CategoryEnumName;
import com.shopping_list.demo.models.entities.Product;
import com.shopping_list.demo.models.service.ProductServiceModel;
import com.shopping_list.demo.models.view.ProductViewModel;
import com.shopping_list.demo.repository.ProductRepository;
import com.shopping_list.demo.services.CategoryService;
import com.shopping_list.demo.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper,
                              CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductSum() == null
                ? BigDecimal.valueOf(0)
                : productRepository.findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryEnumName categoryEnumName) {
        return productRepository.findByCategory_Name(categoryEnumName)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void byAll() {
        productRepository.deleteAll();
    }
}
