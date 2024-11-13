package pl.javastart.zadanie21.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.zadanie21.model.Category;
import pl.javastart.zadanie21.model.Product;
import pl.javastart.zadanie21.repository.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String productsList(@RequestParam(value = "kategoria", required = false) Category category, Model model) {
        double totalPrice;
        if (category != null) {
            totalPrice = productRepository
                    .findByCategory(category)
                    .stream()
                    .mapToDouble(Product::price)
                    .sum();
            model.addAttribute("products", productRepository.findByCategory(category));
            model.addAttribute("totalPrice", totalPrice);
        } else {
            totalPrice = productRepository
                    .findAll()
                    .stream()
                    .mapToDouble(Product::price)
                    .sum();
            model.addAttribute("products", productRepository.findAll());
            model.addAttribute("totalPrice", totalPrice);
        }
        return "products";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product("", 0.0, null));
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam Category category) {
        productRepository.addProduct(new Product(name, price, category));
        return "redirect:/";
    }
}