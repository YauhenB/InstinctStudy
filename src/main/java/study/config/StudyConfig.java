package study.config;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import study.App;
import study.Main;
import study.model.Connection;
import study.service.UserService;
import study.service.impl.UserServiceImpl;

/**
 * Created by yauhen on 27.12.16.
 */
@Configuration
@ComponentScan(basePackages = "study")
@ImportResource("db-config.xml")
public class StudyConfig {


    @Bean
    @Scope("prototype")
    UserService protoUserService() {
        return new UserServiceImpl();
    }

    @Bean
    Main main() {
        return new Main();
    }

    @Bean
    App app(final ApplicationContext context) {
        return new App(context);
    }

    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.url}")
    private String url;

    @Bean
    @Scope("singleton")
    UserFactory userFactory() {
        return new UserFactory();
    }


    @Bean
    @Scope("singleton")
    Connection connection() {
        final Connection connection = new Connection();
        connection.setPassword(password);
        connection.setUrl(url);
        connection.setUsername(username);
        return connection;
    }
}
