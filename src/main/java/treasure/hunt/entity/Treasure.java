package treasure.hunt.entity;

import treasure.hunt.Exception.BusinessException;


/**
 * Treasure entity
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public class Treasure extends MapItem{

    private int number;

    public Treasure(Position position, int number) {
        super(position, "T");
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
        return super.getName() +"(" + this.number +")";
    }

    @Override
    public String fileFormatToString(){
        return this.name + " - " + position.getPositionX() + " - "+position.getPositionY() + " - " + this.number;
    }

    public int getNumber() {
        return number;
    }

    public void removeOneTresure() {
        if(this.number>0) this.number--;
    }
}
