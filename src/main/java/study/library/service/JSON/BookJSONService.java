package study.library.service.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import study.library.dao.BookRepository;

/**
 * Created by yauhen on 5.1.17.
 */
@Controller
@RequestMapping("/json/book")
public class BookJSONService {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("{id}")
    public String getBook(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute("books", bookRepository.findOne(id));
        return "jsonTemplate";
    }

    @GetMapping()
    public String getAll(final Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "jsonTemplate";
    }
}
