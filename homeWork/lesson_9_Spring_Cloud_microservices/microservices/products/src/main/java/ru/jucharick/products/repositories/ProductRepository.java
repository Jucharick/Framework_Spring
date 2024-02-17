package ru.jucharick.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jucharick.products.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
