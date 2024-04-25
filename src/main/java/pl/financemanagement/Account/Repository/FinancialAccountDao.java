package pl.financemanagement.Account.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.financemanagement.Account.Model.Account.FinancialAccount;

import java.util.UUID;

public interface FinancialAccountDao extends CrudRepository<FinancialAccount, Long> {

    FinancialAccount findAccountByExternalId(UUID externalId);

}
