package treasure.hunt.business.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import treasure.hunt.Exception.BusinessException;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitMap {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitMap.class);

    private Position position = new Position(0, 0);
    private ArrayList<Mountain> mountains = new ArrayList<>();
    private ArrayList<Treasure> treasures = new ArrayList<>();
    private LinkedList<Adventurer> adventurers = new LinkedList<>();

    public MapTreasure getItemFromLines(String mapInput) {
        {
            String[] lines = mapInput.split("\n");
            Arrays.stream(lines).forEach(line -> {
                        LOGGER.info(line);
                        String[] values = line.split(" - ");
                        switch (values[0]) {
                            case "C":
                                position = new Position(values[1], values[2]);
                                break;
                            case "M":
                                mountains.add(createMountain(values));
                                break;
                            case "T":
                                treasures.add(createTreasure(values));
                                break;
                            case "A":
                                adventurers.add(createAdventurer(values));
                                break;
                            default:
                                LOGGER.debug("Info not used : {}", values.toString());
                                break;
                        }
                    }
            );

            return new MapTreasure(position.getPositionX(), position.getPositionY(), adventurers, mountains, treasures);
        }
    }

    private Mountain createMountain(String[] positions) {
        return new Mountain(new Position(positions[1], positions[2]));
    }

    private Treasure createTreasure(String[] positionsAndNumberItem) {
        return new Treasure(new Position(positionsAndNumberItem[1], positionsAndNumberItem[2]), Integer.parseInt(positionsAndNumberItem[3]));
    }

    private Adventurer createAdventurer(String[] infoList) {
        String[] dirList = infoList[5].split("");
        List<Direction> directions = Arrays.asList(dirList)
                .stream()
                .map(Direction::valueOfLabel)
                .collect(Collectors.toList());
        LOGGER.info(directions.toString());
        return new Adventurer(infoList[1], new Position(infoList[2], infoList[3]), Orientation.valueOf(infoList[4]), directions);
    }
}