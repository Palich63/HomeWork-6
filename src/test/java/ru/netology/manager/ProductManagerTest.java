package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    private ProductManager productManager = new ProductManager();

    private Book secondBook = new Book(3, 31, "Энтони Бёрджесс", "Заводной апельсин");
    private Smartphone secondSmart = new Smartphone(4, 330, "7.2", "Nokia");
    private Smartphone thirdSmart = new Smartphone(5, 295, "mi 9", "Xiaomi");

    @Test
    void ShouldAddToRepository() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);

        Product[] expected = new Product[]{secondBook, secondSmart};
        Product[] actual = productManager.productAll();

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldDeleteById() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);

        Product[] expected = new Product[]{secondBook, thirdSmart};
        productManager.deleteById(4);
        Product[] actual = productManager.productAll();

                assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearch() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);

//        productManager.searchBy("mi 9");

        Book expected = new Book(3, 31, "Энтони Бёрджесс", "Заводной апельсин");
        Product actual = productManager.searchBy("Заводной апельсин");

        assertEquals(expected, actual);

    }
}