package pl.financemanagement.Account.Model.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
public class FinancialAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID externalId;
    private String name;
    private String accountNumber;
    private BigDecimal amount;
    private Instant createdOn;
    private FinancialCurrency financialCurrency;


}
