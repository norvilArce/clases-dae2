package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Product;
import pe.isil.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "product";
    }

    @GetMapping("/products/add")
    public String productAdd(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/products/edit/{id}")
    public String productEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.read(id));
        return "product-edit";
    }

    @GetMapping("/products/delete/{id}")
    public String productDelete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @PostMapping("/products/save")
    public String productSave(Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String productUpdate(Product product) {
        productService.update(product);
        return  "redirect:/products";
    }

}
