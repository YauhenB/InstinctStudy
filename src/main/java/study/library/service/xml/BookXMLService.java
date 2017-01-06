package study.library.service.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.library.dao.BookRepository;
import study.library.model.Book;
import study.library.service.BookService;

import java.util.List;

/**
 * XML REST for books.
 */
@Controller
@RequestMapping(value = "/rest/book")
public class BookXMLService implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public
    @ResponseBody
    Book getBook(@PathVariable("id") final Long id) {
        final Book book = bookRepository.findOne(id);
        return book;

    }


    @GetMapping(value = "/", produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public
    @ResponseBody
    List<Book> getAll() {

        return (List) bookRepository.findAll();
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
