package study.library.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import study.library.model.Book;

import java.util.List;

/**
 * Created by yauhen on 4.1.17.
 */
public interface BookService {
    @RequestMapping("{id}")
    Book getBook(@PathVariable("id") Long id);

    List<Book> getAll();

    @RequestMapping(value = "create", method = RequestMethod.POST)
    void createBook(@RequestParam("name") String name,
                    @RequestParam("author") String author);

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    void deleteBook(@PathVariable("id") Long id);
}
