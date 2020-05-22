package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

@NoArgsConstructor
public class ProductManager {

    private ProductRepository repository = new ProductRepository();

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
            if (product.matches(text)) {
                Product[] tmpProd = new Product[result.length + 1];
                System.arraycopy(result, 0, tmpProd, 0, result.length);
                tmpProd[tmpProd.length - 1] = product;
                result = tmpProd;
            }

        }
        return result;
    }
}
