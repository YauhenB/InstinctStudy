package study.library.service;

import study.library.model.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yauhen on 22.12.16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface BookWebService {
    @WebMethod
    @GET
    @Path("{id}")
    Book getBook(@PathParam("id") Long id);

    @WebMethod
    @GET
    List<Book> getAll();

    @WebMethod
    @POST
    @Path("create")
    void createBook(@QueryParam("name") String name,
                    @QueryParam("author") String author);

    @WebMethod
    @DELETE
    @Path("delete/{id}")
    void deleteBook(@PathParam("id") Long id);
}
