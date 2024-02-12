package ru.jucharick.AOP_Transactions.money.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jucharick.AOP_Transactions.money.domains.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
