package ru.jucharick.pay.services;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import ru.jucharick.pay.aspect.TrackAction;
import ru.jucharick.pay.aspect.TrackAction;
import ru.jucharick.pay.domains.Account;
import ru.jucharick.pay.repositories.AccountRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    @TrackAction
    @Transactional
    public void transferMoney(long idSender, long idReceiver, Double amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(null);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(null);

        Double senderNewAmount = sender.getAmount() - amount;
        Double receiverNewAmount = receiver.getAmount() + amount;

        if (senderNewAmount >= 0) {
            changeAmount(idSender, senderNewAmount);
            changeAmount(idReceiver, receiverNewAmount);
        } else {
            throw new RuntimeException("У отправителя недостаточно средств");
        }
    }

    private void changeAmount(long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(null);
        account.setAmount(amount);
        account.setUpd_date(LocalDateTime.now());
    }
}
