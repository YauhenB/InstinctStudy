import jpa_task.dao.ClientDao;
import jpa_task.dao.impl.ClientDaoImpl;
import jpa_task.model.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDaoTest {
    private static ClientDao clientDao = new ClientDaoImpl();
    private static Client testClient = new Client();

    @Test
    public void testGetById() {
        assertNotNull(clientDao.getById(1L));
    }

    @Test
    public void testGetAll() {
        assertNotNull(clientDao.getAll());
    }

    @Test
    public void testCreate() {
        Boolean flag = false;
        String name = "test";
        testClient.setName(name);
        testClient.setSurname(name);
        clientDao.create(testClient);
        for (Client client : clientDao.getAll()) {
            name = client.getName().trim();
            if (name.equals("test")) {
                testClient = client;
                flag = true;
            }
        }
        assertTrue(flag);

    }

    @Test
    public void testDelete() {
        clientDao.delete(testClient);
        assertNull(clientDao.getById(testClient.getId()));
    }

    @Test
    public void testGetUserAccs() {
        assertNotNull(clientDao.getClientAccounts(testClient));
    }
}
