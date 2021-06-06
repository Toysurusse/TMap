package treasure.hunt.entity.eunmeration;

import treasure.hunt.Exception.BusinessException;

public enum Orientation {
    N("N"), E("E"), O("O"), S("S");

    public final String label;

    private Orientation(String label) {
        this.label = label;
    }

    public static Orientation valueOfLabel(String label) {
        for (Orientation e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        throw new BusinessException("There is no orientation like this label : "+label);
    }
}
