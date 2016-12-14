import org.apache.log4j.Logger;

/**
 * Created by yauhen on 14.12.16.
 */
public class Consumer extends Thread {
    private static final Logger log = Logger.getLogger(Consumer.class);
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        if (this.product.getValue() > 5)
            this.product.decValue();
    }
}
