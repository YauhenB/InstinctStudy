package study.library.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import study.library.dao.sql.impl.BookDaoImpl;
import study.library.dao.sql.impl.UserDaoImpl;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "study.library.*")
public class AppConfig extends WebMvcConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    @Scope("singleton")
    public UserDaoImpl userDao() {
        return new UserDaoImpl();
    }

    @Bean
    @Scope("singleton")
    public BookDaoImpl bookDao() {
        return new BookDaoImpl();
    }


    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        final TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        LOGGER.info("init resources");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
