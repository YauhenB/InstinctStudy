package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.StudyConfig;

/**
 * Created by yauhen on 27.12.16.
 */


public class Main {




    public static void main(String[] args) {



        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudyConfig.class);

        App app=context.getBean(App.class);
        app.run();


    }


}