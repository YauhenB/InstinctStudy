import org.apache.log4j.Logger;

/**
 * Created by yauhen on 14.12.16.
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Product product=new Product();
        for(int counter=0;counter<200;counter++)
        {
            Producer producer=new Producer(product);
            Consumer consumer=new Consumer(product);
            producer.start();
            consumer.start();
            log.info("Current value:"+product.getValue().toString());

        }
    }
}
