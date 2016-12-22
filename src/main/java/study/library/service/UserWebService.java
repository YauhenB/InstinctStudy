package study.library.service;

import study.library.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public interface UserWebService {
    @WebMethod
    @GET
    @Path("{id}")
    User getUser(@PathParam("id") Long id);

    @WebMethod
    @GET
    List<User> getAll();

    @WebMethod
    @POST
    @Path("create")
    void createUser(@QueryParam("name") String name,
                    @QueryParam("pass") String pass);
    @WebMethod
    @DELETE
    @Path("delete/{id}")
    void deleteUser(@PathParam("id") Long id);
}
