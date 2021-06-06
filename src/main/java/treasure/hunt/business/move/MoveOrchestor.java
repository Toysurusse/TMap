package treasure.hunt.business.move;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treasure.hunt.config.ConfigurationMap;
import treasure.hunt.entity.Adventurer;
import treasure.hunt.entity.MapTreasure;

import java.util.LinkedList;


/**
 * Move all adventurers from the map
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class MoveOrchestor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveOrchestor.class);

    private MapTreasure map;

    @Autowired
    MoveAdventurer moveAdventurer;

    @Autowired
    public ConfigurationMap configurationMap;

    /**
     * Service to move all adventurers while they have turn instruction
     */
    public void moveAdneturers() {
        while (configurationMap.getMapTreasure().isAdventurersGetMoves()) {
            configurationMap.getMapTreasure().getAdventurers().forEach(adventurer->{
                if(adventurer.isMoveLeft()) moveAdventurer.moveAdventurer(configurationMap.getMapTreasure(), adventurer);
            });
            LOGGER.info(configurationMap.getMapTreasure().toString());
        }
    }
}
