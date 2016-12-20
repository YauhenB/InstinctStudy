package study.library.dao.nosql.impl;

import org.bson.Document;
import study.library.dao.BookDao;
import study.library.dao.UserDao;
import study.library.dao.nosql.AbstractDaoNoSql;
import study.library.model.Book;
import study.library.model.User;

import java.util.List;

public class BookDaoNoSqlImpl extends AbstractDaoNoSql<Book> implements BookDao {


    @Override
    public Book load(final Long id) {
        return super.getByParam("id", id).get(0);
    }

    @Override
    public void delete(final Long id) {
        super.delete(load(id));
    }

    @Override
    public List<Book> load() {
        return super.getAll();
    }

    @Override
    public Book load(final String name) {
        return super.getByParam("name", name).get(0);
    }

    @Override
    public String getCollName() {
        return "books";
    }


    @Override
    public Document toMongoObj(final Book entity) {
        Document document = new Document();
        document.put("id", entity.getId());
        document.put("name", entity.getName());
        document.put("author", entity.getAuthor());
        if (entity.getOwner()!=null)
        document.put("owner",entity.getOwner().getId());
        else document.put("owner","null");
        return document;
    }

    @Override
    public Book fromMongoObj(final Document document) {
        Book book = new Book();
        book.setId(document.getLong("id"));
        book.setName(document.getString("free"));
        book.setAuthor(document.getString("author"));
        UserDao userDao=new UserDaoNoSqlImpl();
        User owner=userDao.load(document.getLong("id"));
        book.setOwner(owner);
        return book;
    }
}
