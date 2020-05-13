package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@Data
@NoArgsConstructor
public class ProductManager {

//    ProductManager productManager = new ProductManager();

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void productAdd(Product item) {
        repository.save(item);
    }

    public Product[] productAll(){
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        for (Product product: repository.findAll()){

            }
        return null;
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
