package unit.server.model;

import com.arm.nimbus.collab.server.model.PersistentEntity;
import com.arm.nimbus.collab.server.model.User;
import org.junit.*;

/**
 * TODO description
 *
 * @creator victor
 */
public class PersistentEntityUnitTest {

    @Test
    public void constructor(){

        PersistentEntity entity = new PersistentEntity();

        Assert.assertNotNull(entity.getId());
        Assert.assertNull(entity.getVersion());

    }

    @Test
    public void version(){

        PersistentEntity entity = new PersistentEntity();
        Long version = 1L;
        entity.setVersion(version);
        Assert.assertEquals(version, entity.getVersion());

    }
}
