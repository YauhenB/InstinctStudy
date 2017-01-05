package study.library.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.library.dao.BookDao;
import study.library.dao.sql.impl.BookDaoImpl;
import study.library.model.Book;

import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */
@RestController
@RequestMapping(value = "/rest/book")
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    @RequestMapping(value = "{id}")
    public Book getBook(@PathVariable("id") final Long id) {
        final Book book = bookDao.load(id);
        return book;

    }

    @Override
    @RequestMapping("/")
    public List<Book> getAll() {
        return bookDao.load();
    }


    @Override
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public void createBook(@RequestParam("name") final String name,
                           @RequestParam("author") final String author) {
        final Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookDao.create(book);

    }

    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") final Long id) {
        bookDao.delete(id);
    }

}
