package study.library.dao;

import org.springframework.data.repository.CrudRepository;
import study.library.model.User;

/**
 * Created by yauhen on 5.1.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
