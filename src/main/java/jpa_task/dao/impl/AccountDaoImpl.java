package jpa_task.dao.impl;

import jpa_task.dao.AbstractDao;
import jpa_task.dao.AccountDao;
import jpa_task.model.Account;
import jpa_task.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {
    private static final String ENTITYNAME = "Account";
    private static final Logger LOG = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Override
    public void create(Account account) {
        super.create(account);
    }

    @Override
    public void delete(Account account) {
        super.delete(account);
    }

    public void delById(Long id) {
        super.delById(id, ENTITYNAME);
    }

    @Override
    public Account getById(Long id) {
        return super.getById(id, Account.class);

    }

    public Account getByLogin(String login) {
        String hql = "from Account as acc where acc.login=:login";
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Account> query = session.createQuery(hql, Account.class);
        query.setParameter("login", login);
        session.beginTransaction();
        Account ret;
        try {
            ret = query.getSingleResult();
        } catch (NoResultException ex) {
            LOG.error("No such account, returning null");
            session.close();
            return null;


        }
        session.close();
        return ret;
    }

    @Override
    public List<Account> getAll() {
        return super.getAll(Account.class, ENTITYNAME);
    }
}
