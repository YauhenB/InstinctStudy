package study.library.dao;

import study.library.model.Book;

import java.util.List;


/**
 * Describing methods for @{@link Book} DAO.
 */
public interface BookDao {

    void create(Book book);

    void delete(Book book);

    void delete(Long id);

    Book load(Long id);

    Book load(String name);

    List<Book> load();
}
