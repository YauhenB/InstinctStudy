package study.library.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import study.library.dao.BookDao;
import study.library.dao.UserDao;
import study.library.dao.sql.impl.BookDaoSqlImpl;
import study.library.dao.sql.impl.UserDaoSqlImpl;
import study.library.service.BookService;
import study.library.service.UserService;

import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.URI;

/**
 * Created by yauhen on 21.12.16.
 */
public class Server {
    static final URI BASE_URI = getBaseURI();
    private static final String HOST = "http://localhost/";
    private static final int PORT = 9998;
    private HttpServer server;

    private static URI getBaseURI() {
        return UriBuilder.fromUri(HOST).port(PORT).build();
    }

    /**
     * @throws IOException exception
     */

    public void startServer() throws IOException {

        final Injector injector = Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(new TypeLiteral<UserDao>() {
                }).to(UserDaoSqlImpl.class);

                bind(new TypeLiteral<BookDao>() {
                }).to(BookDaoSqlImpl.class);
            }
        });

        final ResourceConfig rc = new PackagesResourceConfig("study.library");
        final IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
        Endpoint.publish("http://localhost:9988/soap/user", new UserService());
        Endpoint.publish("http://localhost:9988/soap/book", new BookService());
        server = GrizzlyServerFactory.createHttpServer(BASE_URI + "services/", rc, ioc);


    }

    public void stopServer() {
        server.stop();
    }
}
