package JPA_task;

import JPA_task.Util.HibernateUtil;
import JPA_task.Model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by yauhen on 14.12.16.
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        log.info("Transaction started");
        Client client = new Client();
        client.setName("John");
        client.setSurname("Doe");
        session.save(client);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
