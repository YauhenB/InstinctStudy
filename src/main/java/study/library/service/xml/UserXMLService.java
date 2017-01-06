package study.library.service.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import study.library.dao.UserRepository;
import study.library.model.User;
import study.library.service.UserService;

import java.util.List;

/**
 * XML REST for books.
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserXMLService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public
    @ResponseBody
    User getUser(@PathVariable("id") final Long id) {
        final User user = userRepository.findOne(id);
        return user;

    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public
    @ResponseBody
    List<User> getAll() {

        return (List) userRepository.findAll();
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
