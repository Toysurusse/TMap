package treasure.hunt.entity;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String fileFormatToString(){
        return this.name + "- " + position.getPositionX() + " - "+position.getPositionY();
    }
}
