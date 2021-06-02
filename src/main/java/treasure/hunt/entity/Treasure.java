package treasure.hunt.entity;

public class Treasure extends MapItem{

    private int number;

    public Treasure(Position position, int number) {
        super(position);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
