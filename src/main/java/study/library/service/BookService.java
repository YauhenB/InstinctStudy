package study.library.service;

import study.library.dao.BookDao;
import study.library.dao.sql.impl.BookDaoSqlImpl;
import study.library.model.Book;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */

@Consumes("application/xml")
@Produces("application/xml")
@WebService(endpointInterface = "study.library.service.BookWebService")
@Path("book")
public class BookService implements BookWebService {
    private BookDao bookDao = new BookDaoSqlImpl();

    @Override
    @GET
    @Path("{id}")
    public Book getBook(@PathParam("id") final Long id) {
        final Book book = bookDao.load(id);
        return book;

    }

    @Override
    @GET
    public List<Book> getAll() {
        return bookDao.load();
    }


    @Override
    @POST
    @Path("create")
    public void createBook(@QueryParam("name") final String name,
                           @QueryParam("author") final String author) {
        final Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookDao.create(book);

    }

    @Override
    @DELETE
    @Path("delete/{id}")
    public void deleteBook(@PathParam("id") final Long id) {
        bookDao.delete(id);
    }

}
