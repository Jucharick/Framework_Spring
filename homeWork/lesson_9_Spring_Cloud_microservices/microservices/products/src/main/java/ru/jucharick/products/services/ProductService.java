package ru.jucharick.products.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jucharick.products.domains.Product;
import ru.jucharick.products.repositories.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void saleOfProducts(Long id, Integer amount){
        Product product = getProductById(id);
        if (product.getAmount() >= amount) {
            product.setAmount(product.getAmount() - amount);
            productRepository.save(product);
        } else {
            throw new RuntimeException("недостаточно товаров на складе");
        }
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
}
