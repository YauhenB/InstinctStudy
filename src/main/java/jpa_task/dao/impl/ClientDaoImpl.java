package jpa_task.dao.impl;

import jpa_task.dao.AbstractDao;
import jpa_task.dao.ClientDao;
import jpa_task.model.Account;
import jpa_task.model.Client;
import jpa_task.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    private static final String ENTITYNAME = "Client";

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
        super.delById(id, ENTITYNAME);
    }

    @Override
    public Client getById(Long id) {
        return super.getById(id, Client.class);
    }

    @Override
    public List<Client> getAll() {
        return super.getAll(Client.class, ENTITYNAME);
    }

    public List<Account> getClientAccounts(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Account as acc where acc.owner.id=:id";
        TypedQuery<Account> query = session.createQuery(hql, Account.class);
        query.setParameter("id", client.getId());
        List<Account> ret = query.getResultList();
        session.close();
        return ret;

    }

}
