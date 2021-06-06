package treasure.hunt.entity;


/**
 * Position entity : define the position of an entity in the mapTreasure
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public class Position {

    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Position(String positionY, String positionX) {
        this.positionX = Integer.valueOf(positionX) ;
        this.positionY = Integer.valueOf(positionY);
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}

