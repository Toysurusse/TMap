package treasure.hunt.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import treasure.hunt.business.move.MoveAdventurer;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Adventurer entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
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


    /**
     * chack if adventurer have anyMore move left
     * @return <i>true</i> if adventurer have any move, otherwise <i>false</i>
     */
    public boolean isMoveLeft() {
        return this.moves.size() > 0;
    }
    /**
     * add one tresure to adventurer
     */
    public void addOneTreasure() {
        this.treasure++;
    }

    /**
     * @return the length of the name of the adventurer
     */
    public int namelength() {
        return nameAdventurer.length()+4;
    }

    /**
     * Set the new position of the adventurer
     */
    public void setNewPosition(Position position) {
        deleteMove();
        this.setPosition(position);
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

    public void deleteMove() {
        if(this.moves.size()>0)this.moves.remove(0);
    }

}
