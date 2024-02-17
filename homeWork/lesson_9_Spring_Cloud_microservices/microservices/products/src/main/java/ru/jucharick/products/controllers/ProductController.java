package ru.jucharick.products.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jucharick.products.aspect.TrackAction;
import ru.jucharick.products.domains.Product;
import ru.jucharick.products.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @TrackAction
    @PutMapping("/{id}")
    public void saleOfProducts(@PathVariable Long id, @RequestBody Integer amount){
        productService.saleOfProducts(id, amount);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

}
