import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taskClassload.MyClassLoader;

public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        loader.run();
    }
}
