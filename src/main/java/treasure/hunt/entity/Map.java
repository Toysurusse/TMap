package treasure.hunt.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Map {

    private int heigth;
    private int width;
    private LinkedList<Adventurer> adventurers  = new LinkedList();
    private ArrayList<Mountain> mountains  = new ArrayList();
    private ArrayList<Treasure> treasures  = new ArrayList();

    public Map(int heigth, int width, LinkedList<Adventurer> adventurers, ArrayList<Mountain> mountains, ArrayList<Treasure> treasures) {
        this.heigth = heigth;
        this.width = width;
        this.adventurers = adventurers;
        this.mountains = mountains;
        this.treasures = treasures;
    }

    public Map(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
    }

    public Map(String heigth, String width) {
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
        return "Map{" +
                "heigth=" + heigth +
                ", width=" + width +
                ", adventurers=" + adventurers +
                ", mountains=" + mountains +
                ", treasures=" + treasures +
                '}';
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
}
