package unit.server.model;

import com.arm.nimbus.collab.server.model.PersistentEntity;
import com.arm.nimbus.collab.server.model.Product;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * TODO description
 *
 * @creator victor
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Product.class)
public class ProductUnitTest{

    Product p;

    @Before
    public void setUp() throws Exception {
        p = new Product();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void name() throws Exception {
        String name = "mike";
        p.setName(name);
        Assert.assertEquals(name, p.getName());
    }

    @Test
    public void code() throws Exception {
        String code = "c32p56";
        p.setCode(code);
        Assert.assertEquals(code, p.getCode());
    }

    @Test
    public void isPersistentEntity(){
        PersistentEntity entity = p;
        Assert.assertNotNull(entity.getId());
        Assert.assertNull(entity.getVersion());
    }

    @Test
    /*
     * Mock a static method.
     * Really new way of testing your java.
     * @doc http://code.google.com/p/powermock/wiki/MockitoUsage
     */

    public void findByID(){
        PowerMockito.mockStatic(Product.class);
        Mockito.when(Product.findById("id")).thenReturn(new Product());

        Product r = Product.findById("id");
        Assert.assertEquals(p.getCode(), r.getCode());
        Assert.assertEquals(p.getName(), r.getName());
    }
}
