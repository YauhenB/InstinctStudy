package study.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import study.library.dao.UserDao;

/**
 * Created by yauhen on 5.1.17.
 */
@Controller
@RequestMapping("/json/user")
public class UserJSONService  {

    @Autowired
    private UserDao userDao;


    @GetMapping("{id}")
    public String getUser(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute("users", userDao.load(id));
        return "jsonTemplate";
    }

    @GetMapping()
    public String getAll(final Model model) {
        model.addAttribute("users", userDao.load());
        return "jsonTemplate";
    }

}
