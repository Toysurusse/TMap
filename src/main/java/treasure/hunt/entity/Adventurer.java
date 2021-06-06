package treasure.hunt.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import treasure.hunt.business.move.MoveAdventurer;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class to set Adventurer properties.
 *
 * @author Max LB (@Toysurusse)
 */
public class Adventurer extends MapItem{

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveAdventurer.class);

    private int treasure;
    private String nameAdventurer;
    private Orientation orientation;
    private List<Direction> moves;

    public Adventurer(String nameAdventurer, Position position, Orientation orientation, List<Direction> moves) {
        super(position, "A ");
        this.nameAdventurer = nameAdventurer;
        this.orientation = orientation;
        this.moves = moves;
        this.treasure = 0;
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "nameAdventurer='" + nameAdventurer + '\'' +
                ", position=" + getPosition() +
                ", orientation=" + orientation +
                ", moves=" + moves +
                ", treasure=" + treasure +
                '}';
    }

    @Override
    public String getName(){
        return super.getName() + "("+ getNameAdventurer() + ")";
    }

    @Override
    public String fileFormatToString(){
        return this.name + "- " + this.nameAdventurer + "- " + position.getPositionX() + " - "+position.getPositionY() + " - " + this.orientation + " - " + this.treasure;
    }

    public String getNameAdventurer() {
        return nameAdventurer;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<Direction> getMoves() {
        return moves;
    }

    public void setMoves(List<Direction> moves) {
        this.moves = moves;
    }

    public boolean isMoveLeft() {
        return this.moves.size() > 0;
    }

    public void setNewPosition(Position position) {
        deleteMove();
        this.setPosition(position);
    }

    public void deleteMove() {
        if(this.moves.size()>0)this.moves.remove(0);
    }

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    public void addOneTreasure() {
        this.treasure++;
    }

    public int namelength() {
        return nameAdventurer.length()+4;
    }
}
