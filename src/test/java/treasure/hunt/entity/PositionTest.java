package treasure.hunt.entity;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Position entity : define the position of an entity in the mapTreasure
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionTest {

    @Test
    public void init(){
        Position position = new Position(0, 1);

        Assert.assertNotNull(position);
        Assert.assertTrue(position.getPositionX()==0);
        Assert.assertTrue(position.getPositionY()==1);

        Assert.assertNotNull(position.toString());
    }
}

