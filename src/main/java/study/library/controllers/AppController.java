package study.library.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.library.dao.BookDao;
import study.library.dao.UserDao;



@Controller
public class AppController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView usersPage() {
        final ModelAndView model = new ModelAndView("users");
        model.addObject("list", userDao.load());
        return model;
    }


    @RequestMapping(value = "books", method = RequestMethod.GET)
    public ModelAndView booksPage() {
        final ModelAndView model = new ModelAndView("books");
        model.addObject("list", bookDao.load());
        return model;
    }


}
