package study.library.dao.sql.impl;

import org.hibernate.Session;
import study.library.dao.sql.AbstractDaoSql;
import study.library.dao.UserDao;
import study.library.model.Book;
import study.library.model.User;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of @{@link UserDao} using SQL.
 */
public class UserDaoSqlImpl extends AbstractDaoSql<User> implements UserDao {

    public void delete(final Long id) {
        super.load(id, User.class);
    }


    public User load(final Long id) {
        return super.load(id, User.class);
    }

    @Override
    public User load(final String login) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        final User ret = (User) session.createQuery("from User as user where user.login=:login")
                .setParameter("login", login)
                .getSingleResult();
        session.close();
        return ret;

    }

    public List<User> load() {
        return super.load(User.class, "User");
    }

    @Override
    public List<Book> getAssignedBooks(final User owner) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        final String hql = "from Book as book where book.owner=:owner";
        final TypedQuery<Book> query = session.createQuery(hql);
        final List<Book> ret = query.setParameter("owner", owner).getResultList();
        session.close();
        return ret;
    }
}
