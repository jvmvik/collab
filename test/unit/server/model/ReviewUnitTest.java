package unit.server.model;

import com.arm.nimbus.collab.server.model.Review;
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
public class ReviewUnitTest {
    Review cl;

    @Before
    public void setUp(){
        cl = new Review();
    }

    @Test
    public void taskID() throws Exception {
        String taskID = "x129x";
        cl.setTaskID(taskID);
        Assert.assertEquals(taskID, cl.getTaskID());
    }

    @Test
    public void username() throws Exception {
        String username = "x129x";
        cl.setUsername(username);
        Assert.assertEquals(username, cl.getUsername());
    }

    @Test
    public void status(){
        String status = "in progess";
        cl.setStatus(status);
        Assert.assertEquals(status, cl.getStatus());
    }

    @Test
    public void note(){
        String note = "this is a small note";;
        cl.setNote(note);
        Assert.assertEquals(note, cl.getNote());
    }
}
