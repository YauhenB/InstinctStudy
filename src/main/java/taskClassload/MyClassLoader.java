package taskClassload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class MyClassLoader {
    private static final Logger LOG = LoggerFactory.getLogger(MyClassLoader.class);
    private static File dir = new File("jars/");
    private static Scanner sc = new Scanner(System.in);
    private static int counter = 1;
    private static int index = 0;

    public void run() {
        Boolean flag = true;
        while (flag) {
            System.out.println("Choose jar to load, 0 to exit");
            for (String fname : dir.list()) {
                System.out.println(counter + ":" + fname);
            }
            index = sc.nextInt();
            if (index == 0) {
                flag = false;

            } else {
                try {
                    URLClassLoader classLoader;
                    try {
                        String classAdr = dir.getAbsolutePath() + "/" + dir.list()[index - 1];
                        classLoader = URLClassLoader.newInstance(
                                new URL[]{new File(classAdr).toURL()},
                                getClass().getClassLoader());
                        LOG.info(classAdr);
                        Class refTest = classLoader.loadClass("ReferenceTest");
                        Method method = refTest.getDeclaredMethod("run");
                        LOG.info(method.getName());
                        Object instance = refTest.newInstance();
                        method.invoke(instance);

                    } catch (Exception e) {
                        LOG.error("JAR missing or damaged; Cannot load class file");
                    }


                } catch (NullPointerException e) {
                    LOG.error("WRONG INPUT");
                }

            }

        }


    }

}
