package study.library.dao.nosql.impl;

import org.bson.Document;
import study.library.dao.UserDao;
import study.library.dao.nosql.AbstractDaoNoSql;
import study.library.model.Book;
import study.library.model.User;

import java.util.List;

/**
 * Created by yauhen on 16.12.16.
 */
public class UserDaoNoSqlImpl extends AbstractDaoNoSql<User> implements UserDao {


    @Override
    public List<User> load() {
        return super.getAll();
    }

    @Override
    public User load(Long id) {
        return super.getByParam("id", id).get(0);
    }

    @Override
    public void delete(Long id) {
        super.delete(load(id));
    }

    @Override
    public User load(String login) {
        return super.getByParam("login", login).get(0);
    }

    @Override
    public List<Book> getAssignedBooks(User owner) {
        BookDaoNoSqlImpl bookDao = new BookDaoNoSqlImpl();
        return bookDao.getByParam("owner", owner.getId());
    }

    @Override
    public String getCollName() {
        return "users";
    }

    @Override
    public Document toMongoObj(User entity) {
        Document document = new Document();
        document.put("id", entity.getId());
        document.put("login", entity.getLogin());
        document.put("password", entity.getPassword());
        return document;
    }

    @Override
    public User fromMongoObj(Document document) {
        User user = new User();
        user.setId(document.getLong("id"));
        user.setLogin(document.getString("login"));
        user.setPassword(document.getString("password"));
        return user;
    }
}
