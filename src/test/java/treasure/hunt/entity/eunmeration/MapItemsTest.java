package treasure.hunt.entity.eunmeration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.Exception.BusinessException;
import treasure.hunt.entity.MapItem;

import static org.junit.Assert.assertThrows;

/**
 * Enum of map items types
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapItemsTest {

    @Test
    public void init(){
        Assert.assertTrue(MapItems.valueOfLabel("Mountains")== MapItems.MOUNTAINS);
        Assert.assertTrue(MapItems.valueOfLabel("ERROR")== MapItems.PLAIN);
    }
}
