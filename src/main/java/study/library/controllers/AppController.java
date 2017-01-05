package study.library.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.library.dao.sql.impl.BookDaoImpl;
import study.library.dao.sql.impl.UserDaoImpl;
import study.library.model.Book;
import study.library.model.User;

import java.util.List;


@Controller

public class AppController {

    @Autowired
    UserDaoImpl userDao;
    @Autowired
    BookDaoImpl bookDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView usersPage() {
        ModelAndView model=new ModelAndView("users");
        model.addObject("list",userDao.load());
        return  model;
    }


    @RequestMapping(value = "books", method = RequestMethod.GET)
    public ModelAndView booksPage() {
        ModelAndView model = new ModelAndView("books");
        model.addObject("list", bookDao.load());
        return model;
    }


}