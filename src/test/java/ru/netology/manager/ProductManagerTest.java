package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

       private ProductManager productManager = new ProductManager();

    private Book secondBook = new Book(3, 31, "Энтони Бёрджесс", "Заводно апельсин");
    private Smartphone secondSmart = new Smartphone(4, 330, "7.2", "Nokia");

    @Test
    void ShouldAddToRepository() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);

        Product[] expected = new Product[] {secondBook, secondSmart};
        Product[] actual = productManager.productAll();

        assertArrayEquals(actual,expected);



    }

}