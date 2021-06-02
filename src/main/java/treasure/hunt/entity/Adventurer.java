package treasure.hunt.entity;


import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class to set Adventurer properties.
 *
 * @author Max LB (@Toysurusse)
 */
public class Adventurer extends MapItem{

    private final String name;
    private Orientation orientation;
    private List<Orientation> moves;

    public Adventurer(String name, Position position, Orientation orientation, List<Orientation> moves) {
        super(position);
        this.name = name;
        this.orientation = orientation;
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", orientation=" + orientation +
                ", moves=" + moves +
                '}';
    }
}
