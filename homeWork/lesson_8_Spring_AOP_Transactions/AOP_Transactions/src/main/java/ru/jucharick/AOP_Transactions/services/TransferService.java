package ru.jucharick.AOP_Transactions.services;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jucharick.AOP_Transactions.aspect.TrackAction;
import ru.jucharick.AOP_Transactions.domains.Account;
import ru.jucharick.AOP_Transactions.repositories.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    @TrackAction
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(null);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(null);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        changeAmount(idSender, senderNewAmount);
        changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("Oh no! Something went wrong!");
    }

    private void changeAmount(long id, BigDecimal amount) {
        Account account = accountRepository.findById(id).orElseThrow(null);
        account.setAmount(amount);
        account.setUpd_date(LocalDateTime.now());
    }
}
