package study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import study.model.Connection;
import study.model.User;
import study.service.DBService;
import study.service.UserService;

/**
 * Created by yauhen on 28.12.16.
 */
@Component
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private ApplicationContext context;

    @Autowired
    @Qualifier("protoUserService")
    private UserService userService;

    @Autowired
    private DBService dbService;

    public App(ApplicationContext context) {
        this.context = context;
    }

    public void run() {

        User testUser = new User();
        testUser.setSurname("Ivanov");
        testUser.setName("Vasya");
        LOG.info(userService.getInfo(testUser));
        final Connection connection = context.getBean(Connection.class);
        LOG.info(dbService.getInfo(connection));
    }
}
