package ru.jucharick.AOP_Transactions.domains;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cnum;

    @Column(nullable = false)
    private String acid;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = true)
    private LocalDateTime upd_date;
}
