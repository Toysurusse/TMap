package treasure.hunt.entity;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.reader.FileReader;

/**
 * Treasure entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TreasureTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    @Test
    public void init(){
        Treasure treasure = new Treasure(new Position(0, 1),1);

        Assert.assertNotNull(treasure);
        Assert.assertNotNull(treasure.toString());
        Assert.assertNotNull(treasure.fileFormatToString());
        LOGGER.info(treasure.getName());
        Assert.assertTrue(treasure.getName().equals("T(1)"));
        treasure.removeOneTresure();
        Assert.assertTrue(treasure.getNumber()==0);
    }

}
