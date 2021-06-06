package treasure.hunt.entity;

import treasure.hunt.Exception.BusinessException;

public class Treasure extends MapItem{

    private int number;

    public Treasure(Position position, int number) {
        super(position, " T");
        this.number = number;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "position=" + getPosition() +
                "number=" + number +
                '}';
    }

    @Override
    public String getName() {
        return super.getName() + this.number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void removeOneTresure() {
        if(this.number>0) this.number--;
    }
}
