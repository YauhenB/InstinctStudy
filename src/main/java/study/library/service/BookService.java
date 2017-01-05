package study.library.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.library.model.Book;

import java.util.List;

/**
 * Created by yauhen on 4.1.17.
 */
public interface BookService {
    @GetMapping("{id}")
    Book getBook(@PathVariable("id") Long id);

    @GetMapping
    List<Book> getAll();


    @PostMapping(value = "create")
    void createBook(@RequestParam("name") String name,
                    @RequestParam("author") String author);

    @DeleteMapping(value = "delete/{id}")
    void deleteBook(@PathVariable("id") Long id);
}
