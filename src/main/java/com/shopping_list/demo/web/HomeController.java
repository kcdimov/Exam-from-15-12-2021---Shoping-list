package com.shopping_list.demo.web;

import com.shopping_list.demo.models.entities.CategoryEnumName;
import com.shopping_list.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drink", productService.findAllProductsByCategoryName(CategoryEnumName.DRINK));
        model.addAttribute("food", productService.findAllProductsByCategoryName(CategoryEnumName.FOOD));
        model.addAttribute("other", productService.findAllProductsByCategoryName(CategoryEnumName.OTHER));
        model.addAttribute("household", productService.findAllProductsByCategoryName(CategoryEnumName.HOUSEHOLD));
        return "home";
    }

}
