package treasure.hunt.business.move;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.business.init.InitMap;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.MapItems;
import treasure.hunt.entity.eunmeration.MoveResult;
import treasure.hunt.entity.eunmeration.Orientation;

/**
 * Move an adventurer
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MoveAdventurerTest {

    InitMap initMap;

    MapTreasure mapTreasure;
    MoveAdventurer moveAdventurer;

    @Before
    public void createMapTreasure() {
        initMap = new InitMap();
        mapTreasure = initMap.getItemFromLines(
                "C - 3 - 3\n" +
                        "M - 1 - 1\n" +
                        "A - test - 2 - 2 - S - ADG\n" +
                        "T - 1 - 2 - 2");
    }

    @Test
    public void movedOtherAdventurer() {
        moveAdventurer = new MoveAdventurer();
        Adventurer adventurer = moveAdventurer.moveAdventurer(mapTreasure, mapTreasure.getAdventurers().getFirst());
        Assert.assertTrue(adventurer.getMoves().size() == 2);
    }
}