package pl.financemanagement.Account.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.financemanagement.Account.Model.Account.FinancialAccount;

import java.util.Optional;
import java.util.UUID;

public interface FinancialAccountDao extends CrudRepository<FinancialAccount, Long> {

    Optional<FinancialAccount> findAccountByExternalId(UUID externalId);
    void deleteByExternalId(UUID externalId);

}
