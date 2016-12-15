package jpa_task.dao.impl;

import jpa_task.dao.AbstractDao;
import jpa_task.dao.ClientDao;
import jpa_task.model.Account;
import jpa_task.model.Client;
import jpa_task.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yauhen on 14.12.16.
 */
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    @Override
    public void create(Client client) {
        super.create(client);
    }

    @Override
    public void delete(Client client) {
        super.delete(client);
    }

    @Override
    public void delById(Long id) {
        super.delById(id, "Client");
    }

    @Override
    public Client getById(Long id) {
        return super.getById(id, Client.class);
    }

    @Override
    public List<Client> getAll() {
        return super.getAll(Client.class, "Client");
    }

    public List<Account> getClientAccounts(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Account as acc where acc.owner.id=:id";
        TypedQuery<Account> query = session.createQuery(hql, Account.class).setParameter("id", client.getId());
        List<Account> ret = query.getResultList();
        session.close();
        return ret;

    }

}
