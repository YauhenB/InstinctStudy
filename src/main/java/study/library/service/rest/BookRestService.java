package study.library.service.rest;

import study.library.dao.BookDao;
import study.library.dao.sql.impl.BookDaoSqlImpl;
import study.library.model.Book;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */

@Consumes("application/xml")
@Produces("application/xml")
@Path("/rest/book")
public class BookRestService {
    private BookDao bookDao = new BookDaoSqlImpl();

    @GET
    @Path("{id}")
    public Book getUser(@PathParam("id") final Long id) {
        final Book book = bookDao.load(id);
        return book;

    }

    @GET
    public List<Book> getAll() {
        return bookDao.load();
    }


    @POST
    @Path("create")
    public void createUser(@QueryParam("name") final String name,
                           @QueryParam("author") final String author) {
        final Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookDao.create(book);

    }

    @DELETE
    @Path("delete/{id}")
    public void deleteUser(@PathParam("id") final Long id) {
        bookDao.delete(id);
    }

}
