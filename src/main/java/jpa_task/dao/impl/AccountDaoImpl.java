package jpa_task.dao.impl;

import jpa_task.dao.AbstractDao;
import jpa_task.dao.AccountDao;
import jpa_task.model.Account;

import java.util.List;

/**
 * Created by yauhen on 14.12.16.
 */
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {
    @Override
    public void create(Account account) {
        super.create(account);
    }

    @Override
    public void delete(Account account) {
        super.delete(account);
    }

    public void delById(Long id) {
        super.delById(id, "Account");
    }

    @Override
    public Account getById(Long id) {
        return super.getById(id, Account.class);

    }

    @Override
    public List<Account> getAll() {
        return super.getAll(Account.class, "Account");
    }
}
