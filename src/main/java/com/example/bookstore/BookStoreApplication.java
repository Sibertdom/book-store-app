package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("Spring Boot in Action");
            book.setAuthor("Craig Walls");
            book.setIsbn("978-1-61729-254-5");
            book.setPrice(BigDecimal.valueOf(45.99));
            book.setDescription("Comprehensive guide to Spring Boot");

            bookService.save(book);

            System.out.println("=== All books in DB ===");
            bookService.findAll().forEach(System.out::println);
        };
    }
}
