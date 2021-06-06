package treasure.hunt.reader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.config.ConfigurationMap;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Service to write result of the program in an external file
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class FilerWriterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilerWriter.class);

    private MapTreasure mapTreasure;
    private Adventurer adventurer;

    @Autowired
    FilerWriter filerWriter;

    @Before
    public void init(){
        LinkedList<Adventurer> adventurers = new LinkedList<>();
        ArrayList<Mountain> mountains = new ArrayList<>();
        ArrayList<Treasure> treasures = new ArrayList<>();
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.D);
        mountains.add(new Mountain(new Position(0, 1)));
        adventurer=new Adventurer("name", new Position(1,0), Orientation.N, directions );
        adventurers.add(new Adventurer("name", new Position(1,0), Orientation.N, directions ));
        treasures.add(new Treasure(new Position(1, 1), 1));
        mapTreasure = new MapTreasure(2, 2,adventurers ,mountains , treasures);
        ConfigurationMap configurationMap = new ConfigurationMap();
        configurationMap.setMapTreasure(mapTreasure);
    }

    @Test
    public void readFile(){
        filerWriter.writeFile();
    }
}
