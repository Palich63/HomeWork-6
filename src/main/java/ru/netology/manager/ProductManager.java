package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public ProductManager() {

    }

    public void productAdd(Product item) {
        repository.save(item);
    }

    public Product[] allProduct() {
        return repository.findAll();
    }

    public void deleteById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmpProd = new Product[result.length + 1];
                System.arraycopy(result, 0, tmpProd, 0, result.length);
                tmpProd[tmpProd.length - 1] = product;
                result = tmpProd;
            }

        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacture().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
