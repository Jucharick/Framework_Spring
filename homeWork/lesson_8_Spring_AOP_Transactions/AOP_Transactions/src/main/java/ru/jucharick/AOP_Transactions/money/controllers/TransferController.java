package ru.jucharick.AOP_Transactions.money.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jucharick.AOP_Transactions.money.dto.TransferRequest;
import ru.jucharick.AOP_Transactions.money.services.TransferService;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PutMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }
}
