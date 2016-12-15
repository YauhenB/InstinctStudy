package jpa_task.dao;

import jpa_task.model.Account;

import java.util.List;

public interface AccountDao {
    void create(Account account);

    void delete(Account account);

    void delById(Long id);

    Account getById(Long id);

    Account getByLogin(String login);

    List<Account> getAll();

}
