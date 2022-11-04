package com.shopping_list.demo.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

//    Has a Name (unique)
//    an option between (Food, Drink, Household, Other)
//    Has a Description
    private CategoryEnumName name;
    private String description;

    public Category() {
    }

    public Category(CategoryEnumName name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public CategoryEnumName getName() {
        return name;
    }

    public void setName(CategoryEnumName name) {
        this.name = name;
    }

    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
