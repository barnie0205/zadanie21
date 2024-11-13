package pl.javastart.zadanie21.model;

public record Product(
        String name,
        double price,
        Category category
) {

}