package jpa_task.dao;

import jpa_task.model.Account;

import java.util.List;

/**
 * Created by yauhen on 14.12.16.
 */
public interface AccountDao {
    void create(Account account);
    void delete(Account account);
    void delById(Long id);
    Account getById(Long id);
    List<Account> getAll();
}
