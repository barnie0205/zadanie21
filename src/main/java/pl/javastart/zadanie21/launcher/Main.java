package pl.javastart.zadanie21.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.javastart.zadanie21")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}