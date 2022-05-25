package pl.britenet.btnbackendmay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return this.productService.retrieve(productId);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        this.productService.create(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        this.productService.update(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        this.productService.remove(productId);
    }

}
