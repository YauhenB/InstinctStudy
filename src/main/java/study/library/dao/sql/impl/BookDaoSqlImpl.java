package study.library.dao.sql.impl;

import org.hibernate.Session;
import study.library.dao.sql.AbstractDaoSql;
import study.library.dao.BookDao;
import study.library.model.Book;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of @{@link BookDao} using SQL.
 */
public class BookDaoSqlImpl extends AbstractDaoSql<Book> implements BookDao {

    private  static final String ENTITYNAME = "Book";

    public void delete(final Long id) {
        super.delete(id, ENTITYNAME);
    }


    public Book load(final Long id) {
        return super.load(id, Book.class);
    }

    @Override
    public Book load(final String name) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final String hql = "from Book as book where book.name=:name";
        final TypedQuery<Book> query = session.createQuery(hql);
        final Book ret = query.setParameter("name", name).getSingleResult();

        session.getTransaction().commit();
        session.close();
        return ret;

    }

    public List<Book> load() {
        return super.load(Book.class, ENTITYNAME);
    }
}
