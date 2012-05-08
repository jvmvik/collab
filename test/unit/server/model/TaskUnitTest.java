package unit.server.model;

import com.arm.nimbus.collab.server.model.PersistentEntity;
import com.arm.nimbus.collab.server.model.Task;
import com.arm.nimbus.collab.server.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO description
 *
 * @creator victor
 */
public class TaskUnitTest {
    Task t;

    @Before
    public void setUp(){
        t = new Task();
    }

    @Test
    public void title() throws Exception {
        String title = "title";
        t.setTitle(title);
        Assert.assertEquals(title, t.getTitle());
    }

    @Test
    public void content() throws Exception {
        String content = "content";
        t.setContent(content);
        Assert.assertEquals(content, t.getContent());
    }

    @Test
    public void status() throws Exception {
        String status = "status";
        t.setStatus(status);
        Assert.assertEquals(status, t.getStatus());
    }

    @Test
    public void user() throws Exception {
        User user = new User();
        user.setUsername("hello");
        t.setUser(user);
        Assert.assertEquals(user, t.getUser());
    }
}
