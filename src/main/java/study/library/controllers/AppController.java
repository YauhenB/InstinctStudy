package study.library.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import study.library.dao.BookRepository;
import study.library.dao.UserRepository;


@Controller
@RequestMapping("/")

public class AppController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {

        return "home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView usersPage() {
        final ModelAndView model = new ModelAndView("users");
        model.addObject("list", userRepository.findAll());
        return model;
    }


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView booksPage() {
        final ModelAndView model = new ModelAndView("books");
        model.addObject("list", bookRepository.findAll());
        return model;
    }


}
