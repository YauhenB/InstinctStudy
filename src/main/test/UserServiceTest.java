import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.config.StudyConfig;
import study.service.UserService;

/**
 * Created by yauhen on 28.12.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StudyConfig.class)
public class UserServiceTest {

    @Autowired
    @Qualifier("protoUserService")
    UserService service;

    @Test
    public void testService()
    {
        service.testMethod().equals("Hello");
    }


}
