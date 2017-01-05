package study.library.service.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import study.library.dao.UserRepository;

/**
 * Created by yauhen on 5.1.17.
 */
@Controller
@RequestMapping("/json/user")
public class UserJSONService {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("{id}")
    public String getUser(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute("users", userRepository.findOne(id));
        return "jsonTemplate";
    }

    @GetMapping()
    public String getAll(final Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "jsonTemplate";
    }

}
