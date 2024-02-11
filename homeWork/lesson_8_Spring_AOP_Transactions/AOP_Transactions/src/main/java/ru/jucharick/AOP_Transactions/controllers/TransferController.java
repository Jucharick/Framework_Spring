package ru.jucharick.AOP_Transactions.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jucharick.AOP_Transactions.domains.Account;
import ru.jucharick.AOP_Transactions.services.TransferService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PutMapping("/transfer")
    public ResponseEntity<Account> transferMoney(@RequestBody long idSender, long idReceiver,BigDecimal amount) {
        return new ResponseEntity<>(transferService.transferMoney(idSender, idReceiver, amount), HttpStatus.OK);
    }
}
