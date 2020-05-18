package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductManager productManager = new ProductManager();

    private Book secondBook = new Book(3, 31, "Заводной апельсин", "Энтони Бёрджесс");
    private Book thirdBook = new Book(6, 45, "Право на ответ", "Энтони Бёрджесс");
    private Book forthBook = new Book(9, 55, "Энтони Бёрджесс", "Семя желания");
    private Smartphone secondSmart = new Smartphone(4, 330, "7.2", "Nokia");
    private Smartphone thirdSmart = new Smartphone(5, 295, "mi 9", "Xiaomi");
    private Smartphone forthSmart = new Smartphone(7, 450, "mi 8", "Xiaomi");
    private Smartphone fifthSmart = new Smartphone(8, 546, "Заводной апельсин", "Xiaomi");

    @Test
    void ShouldAddToRepository() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);

        Product[] actual = new Product[]{secondBook, secondSmart};
        Product[] expected = productManager.allProduct();

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldDeleteById() {
        productManager.productAdd(secondBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);

        Product[] actual = new Product[]{secondBook, thirdSmart};
        productManager.deleteById(4);
        Product[] expected = productManager.allProduct();

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearchName() {
        productManager.productAdd(secondBook);
        productManager.productAdd(thirdBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);
        productManager.productAdd(forthSmart);
        productManager.productAdd(fifthSmart);

        //Поиск по полю Name
        Product[] actual = new Product[]{secondBook, fifthSmart};
        Product[] expected = productManager.searchBy("Заводной апельсин");

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearch() {
        productManager.productAdd(secondBook);
        productManager.productAdd(thirdBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);
        productManager.productAdd(forthSmart);
        productManager.productAdd(fifthSmart);

        //Поиск по полю Manufacture
        Product[] actual = new Product[]{thirdSmart, forthSmart, fifthSmart};
        Product[] expected = productManager.searchBy("Xiaomi");

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearchNothing() {
        productManager.productAdd(secondBook);
        productManager.productAdd(thirdBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);
        productManager.productAdd(forthSmart);
        productManager.productAdd(fifthSmart);

        //Поис не существующего текста, результат пустой массив
        Product[] actual = new Product[0];
        Product[] expected = productManager.searchBy("9");

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearchNothingMore() {
        productManager.productAdd(secondBook);
        productManager.productAdd(thirdBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);
        productManager.productAdd(forthSmart);
        productManager.productAdd(fifthSmart);

        //Поис не существующего текста, результат пустой массив
        Product[] actual = new Product[0];
        Product[] expected = productManager.searchBy("Право");

        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSearchAuthor() {
        productManager.productAdd(secondBook);
        productManager.productAdd(thirdBook);
        productManager.productAdd(forthBook);
        productManager.productAdd(secondSmart);
        productManager.productAdd(thirdSmart);
        productManager.productAdd(fifthSmart);

        //Поиск по полю Author при условии, что в одном продукте попутаны местами Name и Author
        Product[] actual = new Product[]{secondBook, thirdBook, forthBook};
        Product[] expected = productManager.searchBy("Энтони Бёрджесс");

        assertArrayEquals(actual, expected);
    }
}