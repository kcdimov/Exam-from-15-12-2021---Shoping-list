package com.shopping_list.demo.models.binding;

import com.shopping_list.demo.models.entities.CategoryEnumName;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

//    Has a Name (unique)
//    Name length must be between 3 and 20 characters (inclusive 3 and 20).
//    Has a Description
//    Description min length must be minimum 5(inclusive) characters
//    Has a Price
//    The price must be a positive number
//    Has a Needed Before
//    Date and Time, that cannot be in the past
//    Has a Category
//    Category cannot be null.

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryEnumName category;

    public ProductAddBindingModel() {
    }

    @NotBlank(message = "Te field cannot be empty")
    @Length(min = 3, max = 20, message = "Name length must be min 3 and m 20 characters!")
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "The field cannot be empty")
    @Length(min = 5, message = "Description length must be more than 5 characters")
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @DateTimeFormat(pattern="yyyy-MM-d'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past. Please enter future date")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    @NotNull(message = "Please choose category. The field cannot be empty")
    public CategoryEnumName getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryEnumName category) {
        this.category = category;
        return this;
    }
}
