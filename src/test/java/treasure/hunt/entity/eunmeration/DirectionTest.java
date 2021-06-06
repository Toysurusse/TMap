package treasure.hunt.entity.eunmeration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.Exception.BusinessException;

import static org.junit.Assert.assertThrows;

/**
 * Enum of adventurer directions
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectionTest {
    @Test
    public void constructor(){
        Assert.assertTrue(Direction.valueOfLabel("A")==Direction.A);
        Exception exception = assertThrows(BusinessException.class, () -> {
            Direction.valueOfLabel("F");
        });

        String expectedMessage = "There is no direction like this label : F";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
