package study.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.model.User;
import study.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by yauhen on 27.12.16.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String getInfo(final User user) {
        return user.getName() + " " + user.getSurname();
    }

    @Override
    public String testMethod() {
        return "Hello";
    }

    @PostConstruct
    private void created() {
        LOGGER.info("User service created");
    }

    @PreDestroy
    private void destr() {
        LOGGER.info("User service destroyed");
    }

}
