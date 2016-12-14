import org.apache.log4j.Logger;

/**
 * Created by yauhen on 14.12.16.
 */
public class Producer extends Thread {
    private static final Logger log = Logger.getLogger(Producer.class);
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        if (product.getValue() < 10)
            product.incValue();
    }
}
