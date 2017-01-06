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
import study.library.dao.UserRepository;
import study.library.model.User;

/**
 * JSON REST for users.
 */
@Controller
@RequestMapping("/json/user")
public class UserJSONService {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute("users", userRepository.findOne(id));
        return "jsonTemplate";
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(final Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "jsonTemplate";
    }

    @PostMapping(value = "create")
    public void createUser(@RequestParam("name") final String name,
                           @RequestParam("pass") final String pass) {
        final User user = new User();
        user.setLogin(name);
        user.setPassword(pass);
        userRepository.save(user);

    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {

        userRepository.delete(id);
    }

}
