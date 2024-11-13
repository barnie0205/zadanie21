package pl.javastart.zadanie21.model;

public enum Category {

    FOOD("Art. spożywcze"),
    HOUSEHOLD("Art. gosp. domowego"),
    OTHER("Inne");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}