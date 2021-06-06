package treasure.hunt.entity.eunmeration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.Exception.BusinessException;

import static org.junit.Assert.assertThrows;

/**
 * Enum of adventurer orientation
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrientationTest {

    @Test
    public void constructor(){
        Assert.assertTrue(Orientation.valueOfLabel("S")==Orientation.S);
        Exception exception = assertThrows(BusinessException.class, () -> {
            Orientation.valueOfLabel("DV");
        });

        String expectedMessage = "There is no orientation like this label : DV";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
