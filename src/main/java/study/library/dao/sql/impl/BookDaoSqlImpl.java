package study.library.dao.sql.impl;

import org.hibernate.Session;
import study.library.dao.sql.AbstractDaoSql;
import study.library.dao.BookDao;
import study.library.model.Book;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yauhen on 16.12.16.
 */
public class BookDaoSqlImpl extends AbstractDaoSql<Book> implements BookDao {

    public static final String ENTITYNAME = "Book";

    public void delete(final Long id) {
        super.delById(id, ENTITYNAME);
    }


    public Book load(final Long id) {
        return super.getById(id, Book.class);
    }

    @Override
    public Book load(final String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Book as book where book.name=:name";
        TypedQuery<Book> query = session.createQuery(hql);
        query.setParameter("name", name);
        Book ret = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return ret;

    }

    public List<Book> load() {
        return super.getAll(Book.class, ENTITYNAME);
    }
}
