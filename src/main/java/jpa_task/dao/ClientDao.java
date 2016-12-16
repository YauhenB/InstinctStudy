package jpa_task.dao;

import jpa_task.model.Account;
import jpa_task.model.Client;

import java.util.List;


public interface ClientDao {
    void create(Client client);

    void delete(Client client);

    void delById(Long id);

    Client getById(Long id);

    List<Account> getClientAccounts(Client client);

    List<Client> getAll();
}
