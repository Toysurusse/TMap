package treasure.hunt.entity.eunmeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import treasure.hunt.business.move.MoveOrchestor;

public enum MapItems {

    MOUNTAINS("M", "Mountains"),
    ADVENTURER("A", "Adventurer"),
    TREASURE("T", "Treasure"),
    PLAIN("", "Plain");

    public final String label;
    public final String name;

    private MapItems(String label, String name) {
        this.label = label;
        this.name = name;
    }

    public static MapItems valueOfLabel(String label) {
        for (MapItems e : values()) {
            if (label != null && e.label.equals(label.substring(0,1))) {
                return e;
            }
        }
        return PLAIN;
    }
}
