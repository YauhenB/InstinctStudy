package JPA_task.Dao;

import JPA_task.Model.Account;

/**
 * Created by yauhen on 14.12.16.
 */
public interface AccountDao {
    void createAccount(Account account);
    void delAccount(Long id);
    Account getAccountById(Long id);
}
