package ru.jucharick.pay.dto;

import lombok.Data;


@Data
public class TransferRequest {

    private long senderAccountId;
    private long receiverAccountId;
    private Double amount;

}
