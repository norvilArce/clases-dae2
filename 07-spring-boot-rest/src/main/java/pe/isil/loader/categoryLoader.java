package pe.isil.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pe.isil.model.Category;
import pe.isil.repository.CategoryRepository;

@Configuration
public class categoryLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public categoryLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setDescription("Abarrotes");
        category.setStatus(true);
        categoryRepository.save(category);
    }
}
