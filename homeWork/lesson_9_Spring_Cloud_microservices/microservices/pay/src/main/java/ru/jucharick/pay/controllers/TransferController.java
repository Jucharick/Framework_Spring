package ru.jucharick.pay.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jucharick.pay.dto.TransferRequest;
import ru.jucharick.pay.services.TransferService;


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
