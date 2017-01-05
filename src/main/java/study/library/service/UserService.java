package study.library.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.library.model.User;

import java.util.List;

/**
 * Created by yauhen on 4.1.17.
 */
public interface UserService {
    @GetMapping("{id}")
    User getUser(@PathVariable("id") Long id);

    @GetMapping()
    List<User> getAll();

    @PostMapping(value = "create")
    void createUser(@RequestParam("name") String name,
                    @RequestParam("pass") String pass);

    @DeleteMapping (value = "delete/{id}")
    void deleteUser(@RequestParam("id") Long id);
}
