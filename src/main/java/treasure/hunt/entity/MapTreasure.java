package treasure.hunt.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import treasure.hunt.config.BatchConfiguration;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

/**
 * MapTreasure entity : all info are stored in this entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public class MapTreasure {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

    private static int heigth;
    private static int width;
    private static LinkedList<Adventurer> adventurers;
    private static ArrayList<Mountain> mountains;
    private static ArrayList<Treasure> treasures;
    private static ArrayList<Treasure> storedTreasures = new ArrayList();
    private MapItem[][] mapItems;

    public MapTreasure(int width, int heigth, LinkedList<Adventurer> adventurers, ArrayList<Mountain> mountains, ArrayList<Treasure> treasures) {
        this.heigth = heigth;
        this.width = width;
        this.adventurers = adventurers;
        this.mountains = mountains;
        this.treasures = treasures;
        this.mapItems = new MapItem[width][heigth];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                mapItems[i][j] = new Plain(new Position(i, j));
            }
        }
        adventurers.forEach(adventurer -> mapItems[adventurer.getPosition().getPositionX()][adventurer.getPosition().getPositionY()] = adventurer);
        mountains.forEach(mountain -> mapItems[mountain.getPosition().getPositionX()][mountain.getPosition().getPositionY()] = mountain);
        treasures.forEach(treasure -> mapItems[treasure.getPosition().getPositionX()][treasure.getPosition().getPositionY()] = treasure);
    }

    /**
     * represent a map in logs
     * @return string representing a map of the string
     */
    @Override
    public String toString() {
        StringBuilder map = new StringBuilder("Map{" +
                "heigth=" + heigth +
                ", width=" + width +
                ", adventurers=" + adventurers +
                ", mountains=" + mountains +
                ", treasures=" + treasures +
                '}');
        int charlength = adventurersMaxNameLength();
        for (int i = 0; i < width; i++) {
            map.append("\n");
            for (int j = 0; j < heigth; j++) {
                MapItem value = mapItems[i][j];
                if (value != null)
                    map.append(value.getName() + goodLengthStringMap(charlength - value.getName().length()));
            }
        }
        return map.toString();
    }

    /**
     * represent a map in file Output
     * @return string representing a map of the string for output format
     */
    public ArrayList<String> toFileString() {
        ArrayList<String> map = new ArrayList<>();
        map.add("C - "+ width+" - "+this.heigth);
        mountains.forEach(mountain-> map.add(mountain.fileFormatToString()));
        treasures.forEach(treasure-> map.add(treasure.fileFormatToString()));
        adventurers.forEach(adventurer-> map.add(adventurer.fileFormatToString()));
        return map;
    }

    /**
     * Define the length of the string to have better view on logging map
     *
     * @param length
     * @return space string
     */
    private String goodLengthStringMap(int length) {
        String str = "";
        for (int i = 0; i <= length; i++) {
            str = str + " ";
        }
        return str;
    }


    /**
     * Check if any adventurer have any move left
     *
     * @return <i>true</i> if the adventurer have any move left, <i>false</i> otherwise
     */
    public boolean isAdventurersGetMoves() {
        return this.adventurers.stream().anyMatch(adventurer -> adventurer.isMoveLeft());
    }

    /**
     * move the adventurer to his new position or orientation
     *
     * @param adventurer
     * @param newPositionForAdventurer next position
     * @param orientation new orientation
     */
    public void setNewPositionForAdventurer(Adventurer adventurer, Position newPositionForAdventurer, Orientation orientation) {
        Position oldPosition = new Position(adventurer.getPosition().getPositionX(), adventurer.getPosition().getPositionY());
        if (isOtherPosition(adventurer, newPositionForAdventurer))
            mapItems[oldPosition.getPositionX()][oldPosition.getPositionY()] = checkTreasureLeft(oldPosition);
        adventurer.setNewPosition(newPositionForAdventurer);
        adventurer.setOrientation(orientation);
        mapItems[newPositionForAdventurer.getPositionX()][newPositionForAdventurer.getPositionY()] = adventurer;
    }

    /**
     * add a treasure to the adventurer and remove one treasure to the adventurer
     *
     * @param treasure treasure to remove
     * @param adventurer adventure who earn a treasure
     */
    public void handleTreasure(Treasure treasure, Adventurer adventurer) {
        treasure.removeOneTresure();
        adventurer.addOneTreasure();
        LOGGER.info(treasure.toString());
        if (treasure.getNumber() > 0) {
            this.storedTreasures.add(treasure);
        } else {
            this.treasures.remove(treasure);
        }
    }

    /**
     * function to restore treasure after adventurer turns
     *
     * @param position position of the map
     * @return Treasure if this place contains already a tresure and a Plain otherwose
     */
    public MapItem checkTreasureLeft(Position position) {
        Optional<Treasure> treasure = this.storedTreasures.stream().filter(treasureStored -> treasureStored.getPosition().getPositionX() == position.getPositionX()
                && treasureStored.getPosition().getPositionY() == position.getPositionY()).findFirst();
        if (treasure.isPresent()) {
            this.storedTreasures.remove(treasure.get());
            return treasure.get();
        } else return new Plain(new Position(position.getPositionX(), position.getPositionY()));
    }

    /**
     * check if this adventurer change of position
     *
     * @param adventurer
     * @param position
     * @return <i>true</i> if the adventurer move, otherwise <i>false</i>
     */
    private static boolean isOtherPosition(Adventurer adventurer, Position position) {
        return position.getPositionX() != adventurer.getPosition().getPositionX()
                || position.getPositionY() != adventurer.getPosition().getPositionY();
    }

    /**
     * get the maxLength of adventurers names
     *
     * @return length of the longest name
     */
    private int adventurersMaxNameLength() {
        int nameLength = 0;
        for (int i = 0; i < this.adventurers.size(); i++) {
            int length = this.adventurers.get(i).namelength();
            if (length > nameLength) nameLength = length;
        }
        return nameLength;
    }

    /**
     * get an item from the map
     * @param x positionX
     * @param y positionY
     * @return MapItem on this place
     */
    public MapItem getItemFromMap(int x, int y) {
        return mapItems[x][y];
    }

    public int getHeigth() {
        return heigth;
    }

    public int getWidth() {
        return width;
    }

    public LinkedList<Adventurer> getAdventurers() {
        return adventurers;
    }

    public MapItem[][] getMapItems() {
        return mapItems;
    }
}
