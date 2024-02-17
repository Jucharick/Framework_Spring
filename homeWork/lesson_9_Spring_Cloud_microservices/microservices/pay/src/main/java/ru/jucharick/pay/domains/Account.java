package ru.jucharick.pay.domains;

import jakarta.persistence.*;
import lombok.Data;
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
    private Double amount;

    @Column(nullable = true)
    private LocalDateTime upd_date;
}
