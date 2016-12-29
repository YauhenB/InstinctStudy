package study.service.impl;

import org.springframework.stereotype.Service;
import study.model.Connection;
import study.service.DBService;

/**
 * Created by yauhen on 29.12.16.
 */
@Service
public class DBServiceImpl implements DBService {
    @Override
    public String getInfo(final Connection connection) {
        return "URL: " + connection.getUrl() + "\nUsername: "
                + connection.getUsername() + "\nPassword: " + connection.getPassword();
    }
}
