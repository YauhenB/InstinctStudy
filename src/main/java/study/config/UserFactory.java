package study.config;

import org.springframework.beans.factory.FactoryBean;
import study.model.User;

/**
 * Created by yauhen on 4.1.17.
 */
public class UserFactory implements FactoryBean<User> {
    private String name;
    private String surname;

    public void setName(final String name) {
        this.name = name;

    }


    public void setSurname(final String surname) {
        this.surname = surname;

    }

    @Override
    public User getObject() throws Exception {
        final User user = new User();
        user.setName(name);
        user.setSurname(surname);
        return user;

    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
