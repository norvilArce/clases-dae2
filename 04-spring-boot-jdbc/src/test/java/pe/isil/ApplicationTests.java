package pe.isil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.isil.model.Product;
import pe.isil.repository.JdbcProductRepository;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    private final JdbcProductRepository jdbcProductRepository;

    @Autowired
    ApplicationTests(JdbcProductRepository jdbcProductRepository) {
        this.jdbcProductRepository = jdbcProductRepository;
    }

    @Test
    void createProduct() {
        Product product= new Product(null, "Tornillo de 1/2", 12.0);
        jdbcProductRepository.create(product);
        listAllProducts();
    }

    @Test
    void updateProduct() {
        Product currentProduct= jdbcProductRepository.read(1);
        currentProduct.setName("Madera comun");
        currentProduct.setPrice(8.5);
        jdbcProductRepository.update(currentProduct);
        listAllProducts();
    }

    @Test
    void deleteProduct() {
        Product currentProduct= jdbcProductRepository.read(1);
        jdbcProductRepository.delete(currentProduct.getId());
        listAllProducts();
    }

    private void listAllProducts(){
        List<Product> products = jdbcProductRepository.getAll();
        products.forEach(System.out::println);
    }

}
