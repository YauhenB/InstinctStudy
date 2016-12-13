import org.apache.log4j.Logger;
import taskClassload.MyClassLoader;

public class Main {
    public  static  final Logger log= Logger.getLogger(Main.class);

    public static void main(String[] args) {


       MyClassLoader loader=new MyClassLoader();
       loader.run();
    }
}
