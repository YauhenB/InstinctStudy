import jpa_task.dao.AccountDao;
import jpa_task.dao.ClientDao;
import jpa_task.dao.impl.AccountDaoImpl;
import jpa_task.dao.impl.ClientDaoImpl;
import jpa_task.model.Account;
import jpa_task.model.Client;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AccountDaoTest {
    private static AccountDao accountDao = new AccountDaoImpl();
    private static ClientDao clientDao = new ClientDaoImpl();
    private static Account testAcc = new Account();
    private static Client testClient = new Client();

    @Test
    public void testGetById() {
        assertNotNull(accountDao.getById(1L));
    }

    @Test
    public void testGetAll() {
        assertNotNull(accountDao.getAll());
    }

    @Test
    public void testCreation() {
        testClient = clientDao.getById(1L);
        testAcc.setOwner(testClient);
        testAcc.setLogin("testacc");
        testAcc.setPassword("testpass");
        accountDao.create(testAcc);
        this.testAcc = accountDao.getByLogin("testacc");
        assertNotNull(testAcc);

    }

    @Test
    public void testDelete() {
        accountDao.delById(accountDao.getByLogin("testacc").getId());
        assertNull(accountDao.getByLogin("testacc"));

    }

}
