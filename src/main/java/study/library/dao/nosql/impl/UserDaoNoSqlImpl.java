package study.library.dao.nosql.impl;

import org.bson.Document;
import study.library.dao.UserDao;
import study.library.dao.nosql.AbstractDaoNoSql;
import study.library.model.Book;
import study.library.model.User;

import java.util.List;

/**
 * Implementation of {@link UserDao} using NoSql.
 */
public class UserDaoNoSqlImpl extends AbstractDaoNoSql<User> implements UserDao {




    @Override
    public User load(final Long id) {
        return super.load("id", id).get(0);
    }

    @Override
    public void delete(final Long id) {
        super.delete(load(id));
    }

    @Override
    public User load(final String login) {
        return super.load("login", login).get(0);
    }

    @Override
    public List<Book> getAssignedBooks(final User owner) {
        final BookDaoNoSqlImpl bookDao = new BookDaoNoSqlImpl();
        return bookDao.load("owner", owner.getId());
    }

    @Override
    public String getCollName() {
        return "users";
    }

    @Override
    public Document toMongoObj(final User entity) {
       final Document document = new Document();
        document.put("id", entity.getId());
        document.put("login", entity.getLogin());
        document.put("password", entity.getPassword());
        return document;
    }

    @Override
    public User fromMongoObj(final Document document) {
        final User user = new User();
        user.setId(document.getLong("id"));
        user.setLogin(document.getString("login"));
        user.setPassword(document.getString("password"));
        return user;
    }
}
