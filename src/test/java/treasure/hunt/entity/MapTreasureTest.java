package treasure.hunt.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;
import treasure.hunt.entity.eunmeration.OrientationTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * MapTreasure entity : all info are stored in this entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTreasureTest {

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
    public void constructor() {
        Assert.assertNotNull(mapTreasure.toFileString());
        Assert.assertNotNull(mapTreasure.toString());
        Assert.assertTrue(mapTreasure.isAdventurersGetMoves());

        mapTreasure.setNewPositionForAdventurer(adventurer, new Position(0,0), Orientation.N);
        Adventurer adventurer = (Adventurer) mapTreasure.getItemFromMap(0,0);
        Assert.assertTrue(adventurer.getPosition().getPositionX() ==0);
        Assert.assertTrue(adventurer.getPosition().getPositionY() ==0);

        Treasure treasure = (Treasure) mapTreasure.getItemFromMap(1,1);
        mapTreasure.handleTreasure(treasure, adventurer);
        Assert.assertTrue(treasure.getNumber() == 0);

        Assert.assertNotNull(mapTreasure.checkTreasureLeft(new Position(0,0)));

        Assert.assertTrue(mapTreasure.getHeigth() ==2);
        Assert.assertTrue(mapTreasure.getWidth() ==2);
        Assert.assertNotNull(mapTreasure.getAdventurers());
        Assert.assertNotNull(mapTreasure.getMapItems());
    }
}
