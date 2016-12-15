package jpa_task.dao;

import jpa_task.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yauhen on 15.12.16.
 */
public abstract class AbstractDao<T> {
    private T entity;

    public void create(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public T getById(Long id, Class model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T ret = (T) session.get(model, id);
        session.getTransaction().commit();
        session.close();
        return ret;
    }

    public void delById(Long id, String table) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "Delete from ".concat(table);
        hql.concat(" where id=:id");
        Query query = session.createQuery(hql).setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<T> getAll(Class model, String table) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from ".concat(table);
        TypedQuery<T> query = session.createQuery(hql, model);
        List<T> ret = query.getResultList();
        session.close();
        return ret;
    }
}
