package ru.jucharick.AOP_Transactions.products.domains;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = true)
        private int amount;

        @Column(nullable = true)
        private Double price;
}
