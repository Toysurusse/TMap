package treasure.hunt.business.move;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treasure.hunt.business.init.InitMap;
import treasure.hunt.config.ConfigurationMap;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Move all adventurers from the map
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class MoveOrchestorTest {

    private MapTreasure mapTreasure;
    private Adventurer adventurer;
    private MoveOrchestor moveOrchestor;

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
    public void movedOtherAdventurer() {
        ConfigurationMap configurationMap = new ConfigurationMap();
        configurationMap.setMapTreasure(mapTreasure);
        moveOrchestor = new MoveOrchestor();
        moveOrchestor.moveAdneturers();
        Assert.assertFalse(configurationMap.getMapTreasure().isAdventurersGetMoves());
    }
}
