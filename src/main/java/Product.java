import org.apache.log4j.Logger;

/**
 * Created by yauhen on 14.12.16.
 */
public class Product {
    private static final Logger log = Logger.getLogger(Product.class);
    private Integer value;

    public Product() {
        this.value = 10;
    }

    public Integer getValue() {
        return value;
    }

    public void incValue() {
        this.value++;
        log.info("Inc");
    }


    public void decValue() {
        this.value--;
        log.info("Dec");
    }
}
