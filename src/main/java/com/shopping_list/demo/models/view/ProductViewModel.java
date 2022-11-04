package com.shopping_list.demo.models.view;

import java.math.BigDecimal;

public class ProductViewModel {

    private long id;
    private BigDecimal price;
    private String name;

    public ProductViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
