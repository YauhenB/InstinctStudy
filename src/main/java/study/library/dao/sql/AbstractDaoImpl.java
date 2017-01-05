package study.library.dao.sql;

import org.hibernate.Session;
import org.hibernate.query.Query;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Common DAO methods for both types, using SQL database.
 *
 * @param <T> Entity name
 */
public abstract class AbstractDaoImpl<T> {

    /**
     * Creating or updating an entity instance.
     *
     * @param entity Entity instance to save/update
     */
    public void create(final T entity) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (session.contains(entity)) {
            session.update(entity);
        } else {
            session.save(entity);
        }
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deleting an entity instance from DB.
     *
     * @param entity Entity instance to delete
     */
    public void delete(final T entity) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (session.contains(entity)) {
            session.delete(entity);
        }
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deleting an entity instace by ID.
     *
     * @param id    ID of database record
     * @param table Name of table containing record
     */
    public void delete(final Long id, final String table) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final String hql = "Delete from ".concat(table).concat(" where id=:id");
        final Query query = session.createQuery(hql).setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Loading an instance of entity from DB.
     *
     * @param id    ID of DB record
     * @param model Entity class for casting
     * @return Instance of entity
     */
    public T load(final Long id, final Class model) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final T ret = (T) session.get(model, id);
        session.getTransaction().commit();
        session.close();
        return ret;
    }

    /**
     * Loading all instances from DB.
     *
     * @param model Entity class for casting.
     * @param table Name of table containing record
     * @return List of all instances
     */
    public List<T> load(final Class model, final String table) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final String hql = "from ".concat(table);
        final TypedQuery<T> query = session.createQuery(hql, model);
        final List<T> ret = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return ret;
    }

}
