package treasure.hunt.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import treasure.hunt.config.BatchConfiguration;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class MapTreasure {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

    private int heigth;
    private int width;
    private LinkedList<Adventurer> adventurers  = new LinkedList();
    private ArrayList<Mountain> mountains  = new ArrayList();
    private ArrayList<Treasure> treasures  = new ArrayList();
    private ArrayList<Treasure> storedTreasures = new ArrayList();
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
                mapItems[i][j] = new Plain(new Position(i,j));
            }
        }
        adventurers.forEach(adventurer -> mapItems[adventurer.getPosition().getPositionX()][adventurer.getPosition().getPositionY()] = adventurer);
        mountains.forEach(mountain -> mapItems[mountain.getPosition().getPositionX()][mountain.getPosition().getPositionY()] = mountain);
        treasures.forEach(treasure -> mapItems[treasure.getPosition().getPositionX()][treasure.getPosition().getPositionY()] = treasure);
    }

    public MapTreasure(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
    }

    public MapTreasure(String heigth, String width) {
        this.heigth = Integer.valueOf(heigth);
        this.width = Integer.valueOf(width);
    }

    /**
     * Create a string view of the map
     *
     * @return string of the map
     */
    @Override
    public String toString() {
        LOGGER.info("Map{" +
                "heigth=" + heigth +
                ", width=" + width +
                ", adventurers=" + adventurers +
                ", mountains=" + mountains +
                ", treasures=" + treasures +
                '}');
        StringBuilder map = new StringBuilder("Map{" +
                "heigth=" + heigth +
                ", width=" + width +
                ", adventurers=" + adventurers +
                ", mountains=" + mountains +
                ", treasures=" + treasures +
                '}');
        for (int i = 0; i < width; i++) {
            map.append("\n|");
            for (int j = 0; j < heigth; j++) {
                MapItem value = mapItems[i][j];
                if(value != null)map.append(value.getName()+"|");
            }
        }
        return map.toString();
    }

    public MapItem getItemFromMap(int x, int y){
        return mapItems[x][y];
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public LinkedList<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(LinkedList<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    public ArrayList<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(ArrayList<Mountain> mountains) {
        this.mountains = mountains;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public MapItem[][] getMapItems() {
        return mapItems;
    }

    public void setMapItems(MapItem[][] mapItems) {
        this.mapItems = mapItems;
    }

    public boolean isAdventurersGetMoves(){
        return this.adventurers.stream().anyMatch(adventurer -> adventurer.isMoveLeft());
    }

    public void setNewPositionForAdventurer(Adventurer adventurer, Position newPositionForAdventurer, Orientation orientation) {
        Position oldPosition = new Position (adventurer.getPosition().getPositionX(),adventurer.getPosition().getPositionY());
        if(isOtherPosition(adventurer, newPositionForAdventurer))mapItems[oldPosition.getPositionX()][oldPosition.getPositionY()] = checkTreasureLeft(oldPosition);
        adventurer.setNewPosition(newPositionForAdventurer);
        adventurer.setOrientation(orientation);
        mapItems[newPositionForAdventurer.getPositionX()][newPositionForAdventurer.getPositionY()] = adventurer;
    }

    public void handleTreasure(Treasure treasure, Adventurer adventurer, Position nextPosition) {
        treasure.removeOneTresure();
        adventurer.addOneTreasure();
        LOGGER.info(treasure.toString());
        if(treasure.getNumber()>0){
            this.storedTreasures.add(treasure);
        } else {
            this.treasures.remove(treasure);
        }
    }
    public MapItem checkTreasureLeft(Position position) {
        Optional<Treasure> treasure = this.storedTreasures.stream().filter(treasureStored -> treasureStored.getPosition().getPositionX() == position.getPositionX()
                && treasureStored.getPosition().getPositionY() == position.getPositionY()).findFirst();
        if (treasure.isPresent()) {
            this.storedTreasures.remove(treasure.get());
            return treasure.get();
        }
        else return new Plain(new Position (position.getPositionX(), position.getPositionY()));
    }

    private static boolean isOtherPosition(Adventurer adventurer, Position position) {
        return position.getPositionX() != adventurer.getPosition().getPositionX()
                || position.getPositionY() != adventurer.getPosition().getPositionY();
    }
}
