package treasure.hunt.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Moutain entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MountainTest{

    @Test
    public void init(){
        Mountain mountains = new Mountain(new Position(0, 1));

        Assert.assertNotNull(mountains);
    }
}
