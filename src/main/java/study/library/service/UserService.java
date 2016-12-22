package study.library.service;

import study.library.dao.UserDao;
import study.library.dao.sql.impl.UserDaoSqlImpl;
import study.library.model.User;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yauhen on 21.12.16.
 */

@Consumes("application/xml")
@Produces("application/xml")
@WebService(endpointInterface = "study.library.service.UserWebService")
@Path("user")
public class UserService implements UserWebService {
    private UserDao userDao = new UserDaoSqlImpl();


    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") final Long id) {
        final User user = userDao.load(id);
        return user;

    }


    @GET
    public List<User> getAll() {
        return userDao.load();
    }



    @POST
    @Path("create")
    public void createUser(@QueryParam("name") final String name,
                           @QueryParam("pass") final String pass) {
        final User user = new User();
        user.setLogin(name);
        user.setPassword(pass);
        userDao.create(user);

    }


    @DELETE
    @Path("delete/{id}")
    public void deleteUser(@PathParam("id") final Long id) {
        userDao.delete(id);
    }

}
