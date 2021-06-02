package treasure.hunt.entity;

public abstract class MapItem {
    protected Position position;

    public MapItem(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "position=" + position +
                '}';
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
