package study.library.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import study.library.model.User;

import java.util.List;

/**
 * Created by yauhen on 4.1.17.
 */
public interface UserService {
    @RequestMapping("{id}")
    User getUser(@PathVariable("id") Long id);

    @RequestMapping()
    List<User> getAll();

    @RequestMapping(value = "create", method = RequestMethod.POST)
    void createUser(@RequestParam("name") String name,
                    @RequestParam("pass") String pass);

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    void deleteUser(@RequestParam("id") Long id);
}
