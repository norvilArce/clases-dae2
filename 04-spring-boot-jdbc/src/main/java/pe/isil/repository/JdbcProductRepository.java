package pe.isil.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.isil.model.Product;

import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Product product) {
        final String SQL = "INSERT INTO product (name, price) VALUES (?,?)";
        jdbcTemplate.update(SQL, product.getName(), product.getPrice());
    }

    @Override
    public Product read(Integer id) {
        final String SQL = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(SQL, getProductRowMapper(), id);
    }

    @Override
    public void update(Product product) {
        final String SQL = "UPDATE product SET name=?, price=? WHERE id=?";
        jdbcTemplate.update(SQL, product.getName(), product.getPrice(), product.getId());
    }

    @Override
    public void delete(Integer id) {
        final String SQL = "DELETE product WHERE id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Product> getAll() {
        final String SQL = "SELECT * FROM product";
        return jdbcTemplate.query(SQL, getProductRowMapper());
    }

    private RowMapper<Product> getProductRowMapper() {
        return (r, i) -> {
            int id1 = r.getInt("id");
            String name = r.getString("name");
            double price = r.getDouble("price");
            return new Product(id1, name, price);
        };
    }
}
