package study.library.dao.sql.impl;

import org.hibernate.Session;
import study.library.dao.sql.AbstractDaoSql;
import study.library.dao.UserDao;
import study.library.model.Book;
import study.library.model.User;
import study.library.util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoSqlImpl extends AbstractDaoSql<User> implements UserDao {

    public void delete(final Long id) {
        super.getById(id, User.class);
    }


    public User load(final Long id) {
        return super.getById(id, User.class);
    }

    @Override
    public User load(final String login) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        User ret = (User) session.createQuery("from User as user where user.login=:login")
                .setParameter("login", login)
                .getSingleResult();
        session.close();
        return ret;

    }

    @Override
    public List<Book> getAssignedBooks(final User owner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Book as book where book.owner=:owner";
        TypedQuery<Book> query = session.createQuery(hql);
        query.setParameter("owner", owner);
        List<Book> ret = query.getResultList();
        session.close();
        return ret;
    }

    public List<User> load() {
        return super.getAll(User.class, "User");
    }
}
