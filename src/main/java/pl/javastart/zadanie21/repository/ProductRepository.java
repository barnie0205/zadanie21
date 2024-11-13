package pl.javastart.zadanie21.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.zadanie21.model.Category;
import pl.javastart.zadanie21.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // dane testowe
        products.add(new Product("Mleko", 3.49, Category.FOOD));
        products.add(new Product("Czekolada", 7.49, Category.FOOD));
        products.add(new Product("Lodówka", 1499.99, Category.HOUSEHOLD));
        products.add(new Product("Pralka", 999.99, Category.HOUSEHOLD));
        products.add(new Product("Książka", 49.99, Category.OTHER));
        products.add(new Product("Długopis", .99, Category.OTHER));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public List<Product> findByCategory(Category category) {
        return products.stream()
                .filter(product -> product.category() == category)
                .collect(Collectors.toList());
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}