package study.library.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.library.dao.UserDao;
import study.library.dao.sql.impl.UserDaoImpl;
import study.library.model.User;

import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */



@RestController
@RequestMapping(value = "/rest/user")
public class UserServiceImpl implements  UserService {
    private UserDao userDao = new UserDaoImpl();


    @Override
    @RequestMapping(value = "{id}")
    public User getUser(@PathVariable("id") final Long id) {
        final User user = userDao.load(id);
        return user;

    }


    @Override
    @RequestMapping("/")
    public List<User> getAll() {
        return userDao.load();
    }


    @Override
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public void createUser(@RequestParam("name") final String name,
                           @RequestParam("pass") final String pass) {
        final User user = new User();
        user.setLogin(name);
        user.setPassword(pass);
        userDao.create(user);

    }


    @Override
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") final Long id) {
        userDao.delete(id);
    }

}
