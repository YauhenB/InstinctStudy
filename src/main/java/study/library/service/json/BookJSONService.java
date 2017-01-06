package study.library.service.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.library.dao.BookRepository;
import study.library.model.Book;

/**
 * JSON REST for books.
 */
@Controller
@RequestMapping("/json/book")
public class BookJSONService {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBook(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute("books", bookRepository.findOne(id));
        return "jsonTemplate";
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(final Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "jsonTemplate";
    }


    @PostMapping(value = "create")
    public void createBook(@RequestParam("name") final String name,
                           @RequestParam("author") final String author) {
        final Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookRepository.save(book);

    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        bookRepository.delete(id);
    }
}
