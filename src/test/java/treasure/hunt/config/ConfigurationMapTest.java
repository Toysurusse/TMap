package treasure.hunt.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationMapTest {

    private MapTreasure mapTreasure;
    private Adventurer adventurer;

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
    }

    @Test
    public void constructor(){
        ConfigurationMap configurationMap = new ConfigurationMap();
        configurationMap.setMapTreasure(mapTreasure);

        Assert.assertEquals(configurationMap.getMapTreasure(), mapTreasure);
    }
}
