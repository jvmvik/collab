package unit.server.model;

import com.arm.nimbus.collab.server.model.PersistentEntity;
import com.arm.nimbus.collab.server.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO description
 *
 * @creator victor
 */
public class UserUnitTest {
    User u;

    @Before
    public void setUp(){
        u = new User();
    }

    @Test
    public void username() throws Exception {
        String username = "vicben01";
        u.setUsername(username);
        Assert.assertEquals(username, u.getUsername());
    }

    @Test
    public void role() throws Exception {
        String role = "developer";
        u.setRole(role);
        Assert.assertEquals(role, u.getRole());
    }

    @Test
    public void isPersistentEntity(){
        PersistentEntity entity = u;
        Assert.assertNotNull(entity.getId());
        Assert.assertNull(entity.getVersion());
    }
}
