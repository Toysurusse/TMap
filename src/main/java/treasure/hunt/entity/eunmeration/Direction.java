package treasure.hunt.entity.eunmeration;

import treasure.hunt.Exception.BusinessException;

/**
 * Enum of adventurer directions
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public enum Direction {
    A("A"), R("R"), D("D"), G("G");

    public final String label;

    private Direction(String label) {
        this.label = label;
    }

    /**
     * function to get enum from label
     *
     * @param label label of the string
     * @return Direction
     * @throws BusinessException if Direction not recognized
     */
    public static Direction valueOfLabel(String label) throws BusinessException {
        for (Direction e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        throw new BusinessException("There is no direction like this label : "+label);
    }
}
