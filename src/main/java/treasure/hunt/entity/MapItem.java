package treasure.hunt.entity;

/**
 * Map item entity abstract entity to shared field between entities
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public abstract class MapItem {
    protected Position position;
    protected String name;

    public MapItem(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "position=" + position +
                "name=" + name +
                '}';
    }

    /**
     * format ot output string info
     * @return file String format
     */
    public String fileFormatToString(){
        return this.name + "- " + position.getPositionX() + " - "+position.getPositionY();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

}
