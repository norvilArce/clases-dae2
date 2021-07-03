package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.repository.JdbcProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    final JdbcProductRepository jdbcProductRepository;

    @Autowired
    public ProductServiceImpl(JdbcProductRepository jdbcProductRepository) {
        this.jdbcProductRepository = jdbcProductRepository;
    }

    @Override
    public void create(Product product) {
        jdbcProductRepository.create(product);
    }

    @Override
    public Product read(Integer id) {
        return jdbcProductRepository.read(id);
    }

    @Override
    public void update(Product product) {
        jdbcProductRepository.update(product);
    }

    @Override
    public void delete(Integer id) {
        jdbcProductRepository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return jdbcProductRepository.getAll();
    }
}
