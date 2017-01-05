package study.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.library.dao.BookDao;
import study.library.model.Book;

import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */
@RestController
@RequestMapping(value = "/rest/book")
public class BookXMLService implements BookService {

    @Autowired
    private BookDao bookDao;


    @GetMapping(value = "{id}")
    public Book getBook(@PathVariable("id") final Long id) {
        final Book book = bookDao.load(id);
        return book;

    }


    @GetMapping("/")
    public List<Book> getAll() {
        return bookDao.load();
    }


    @PostMapping(value = "create")
    public void createBook(@RequestParam("name") final String name,
                           @RequestParam("author") final String author) {
        final Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookDao.create(book);

    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        bookDao.delete(id);
    }


}
