package treasure.hunt.entity.eunmeration;

import treasure.hunt.Exception.BusinessException;

/**
 * Enum of adventurer orientation
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public enum Orientation {
    N("N"), E("E"), O("O"), S("S");

    public final String label;

    private Orientation(String label) {
        this.label = label;
    }

    /**
     * function to get enum from label
     *
     * @param label label of the string
     * @return Orientation
     */
    public static Orientation valueOfLabel(String label) {
        for (Orientation e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        throw new BusinessException("There is no orientation like this label : "+label);
    }
}
