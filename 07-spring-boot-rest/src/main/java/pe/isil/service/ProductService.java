package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CrudService<Product, Integer> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Integer id) {
        return findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                }).orElse(false);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> findAll() {
        return Optional.of(productRepository.findAll());
    }

    public Optional<List<Product>> getByCategoryId(Integer id){
        return Optional.of(productRepository.findByCategoryId(id));
    }
}
