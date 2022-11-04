package com.shopping_list.demo.repository;

import com.shopping_list.demo.models.entities.CategoryEnumName;
import com.shopping_list.demo.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT SUM (p.price) FROM Product p ")
    BigDecimal findTotalProductSum();

    List<Product> findByCategory_Name(CategoryEnumName categoryEnumName);
}
