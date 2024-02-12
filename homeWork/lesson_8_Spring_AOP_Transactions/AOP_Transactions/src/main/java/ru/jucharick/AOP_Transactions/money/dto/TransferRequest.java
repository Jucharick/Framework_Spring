package ru.jucharick.AOP_Transactions.money.dto;

import lombok.Data;


@Data
public class TransferRequest {

    private long senderAccountId;
    private long receiverAccountId;
    private Double amount;

}
