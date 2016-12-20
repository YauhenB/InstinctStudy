package study.library.dao.sql;

import org.hibernate.Session;
import org.hibernate.query.Query;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDaoSql<T> {


    public void create(final T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (session.contains(entity)) {
            session.update(entity);
        } else {
            session.save(entity);
        }
        session.getTransaction().commit();
        session.close();
    }


    public void delete(final T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (session.contains(entity)) {
            session.delete(entity);
        }
        session.getTransaction().commit();
        session.close();
    }


    public T getById(final Long id, final Class model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T ret = (T) session.get(model, id);
        session.getTransaction().commit();
        session.close();
        return ret;
    }


    public void delById(final Long id, final String table) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "Delete from ".concat(table).concat(" where id=:id");
        Query query = session.createQuery(hql).setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    public List<T> getAll(final Class model, final String table) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from ".concat(table);
        TypedQuery<T> query = session.createQuery(hql, model);
        List<T> ret = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return ret;
    }

}
