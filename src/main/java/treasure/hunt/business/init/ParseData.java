package treasure.hunt.business.init;

import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseData {

    public Map getItem(String str) {
        {
            Position position = new Position(0, 0);
            ArrayList<Mountain> mountains = new ArrayList<>();
            ArrayList<Treasure> treasures = new ArrayList<>();
            LinkedList<Adventurer> adventurers = new LinkedList<>();

            String [] values = str.split(" - ");
            switch (values[0]) {
                case "C" : position = new Position(values[1], values[2]);
                case "M" : mountains.add(createMountain(values));
                case "T" : treasures.add(createTreasure(values));
                case "A" : adventurers.add(createAdventurer(values));
                //TODO : catch errors and commentaries
            }
            return new Map(position.getPositionX(), position.getPositionY(), adventurers, mountains, treasures);
        }
    }

    public Map createMap(String[] positions) {
        return new Map(positions[1], positions[2]);
    }

    public Mountain createMountain(String[] positions) {
        return new Mountain(new Position(positions[1], positions[2]));
    }

    public Treasure createTreasure(String[] positionsAndNumberItem) {
        return new Treasure(new Position(positionsAndNumberItem[1], positionsAndNumberItem[2]), Integer.parseInt(positionsAndNumberItem[3]));
    }

    public Adventurer createAdventurer(String[] infoList) {
        List<Orientation> orientations = Arrays.asList(infoList[5].split(""))
                .stream()
                .map(Orientation::valueOf)
                .collect(Collectors.toList());
        return new Adventurer(infoList[1],new Position(infoList[2], infoList[3]), Orientation.valueOf(infoList[4]), orientations);
    }
}