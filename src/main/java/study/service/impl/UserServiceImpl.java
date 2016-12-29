package study.service.impl;

import org.springframework.stereotype.Service;
import study.model.User;
import study.service.UserService;

/**
 * Created by yauhen on 27.12.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getInfo(final User user) {
        return user.getName() + " " + user.getSurname();
    }

    @Override
    public String testMethod() {
        return "Hello";
    }
}
