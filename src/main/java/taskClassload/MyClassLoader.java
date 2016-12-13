package taskClassload;

import org.apache.log4j.Logger;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;


/**
 * Created by yauhen on 13.12.16.
 */
public class MyClassLoader {
    private static final Logger log = Logger.getLogger(MyClassLoader.class);
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
                        log.info(classAdr);
                        Class refTest = classLoader.loadClass("ReferenceTest");

                        Method method = refTest.getDeclaredMethod("run");
                        log.info(method.getName());
                        Object instance = refTest.newInstance();
                        method.invoke(instance);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } catch (NullPointerException e) {
                    log.error("WRONG INPUT");
                }

            }

        }


    }

}
