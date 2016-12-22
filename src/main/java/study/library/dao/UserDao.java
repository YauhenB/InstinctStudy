package study.library.dao;

import study.library.model.Book;
import study.library.model.User;

import java.util.List;

/**
 * Describing methods for @{@link User} DAO.
 */
public interface UserDao {

    void create(User user);

    void delete(User user);

    void delete(Long id);

    User load(Long id);

    User load(String login);

    List<User> load();

    List<Book> getAssignedBooks(User owner);
}
