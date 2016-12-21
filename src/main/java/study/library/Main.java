package study.library;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import study.library.dao.UserDao;
import study.library.dao.sql.impl.UserDaoSqlImpl;
import study.library.util.Server;

/**
 * Created by yauhen on 19.12.16.
 */
public class Main extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(new TypeLiteral<UserDao>() {
                }).to(UserDaoSqlImpl.class);

                final ResourceConfig rc = new PackagesResourceConfig("study.library");
                for (Class<?> resource : rc.getClasses()) {
                    bind(resource);
                }
                serve("/services/*").with(GuiceContainer.class);
            }
        });
    }


    public static void main(String[] args) {
        final Server server = new Server();
        try {
            server.startServer();
            System.in.read();
            server.stopServer();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
