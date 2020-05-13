package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository product = new ProductRepository();

    private Book firstBook = new Book(1, 25, "Олдос Хаксли", "О дивный новый мир");
    private Smartphone firstSmart = new Smartphone(2, 450, "g8 Plus", "Motorola");


    @Test
    void shouldSaveBook() {

        product.save(firstBook);
        product.save(firstSmart);
        Product[] expected = new Product[]{firstBook, firstSmart};
        Product[] actual = product.findAll();

        assertArrayEquals(actual, expected);


    }
}