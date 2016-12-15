package JPA_task.Dao;

import JPA_task.Model.Account;
import JPA_task.Model.Client;

import java.util.List;

/**
 * Created by yauhen on 14.12.16.
 */
public interface ClientDao {
     void addClient(Client client);
     void delClient(Client client);
     Client getClientById(Long id);
     List<Account> getClientAccounts(Client client);

}
