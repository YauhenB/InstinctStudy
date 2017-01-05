package study.library.dao;

import org.springframework.data.repository.CrudRepository;
import study.library.model.Book;

/**
 * Created by yauhen on 5.1.17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
