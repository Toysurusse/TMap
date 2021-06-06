package treasure.hunt.entity.eunmeration;

import treasure.hunt.Exception.BusinessException;

public enum Direction {
    A("A"), R("R"), D("D"), G("G");

    public final String label;

    private Direction(String label) {
        this.label = label;
    }

    public static Direction valueOfLabel(String label) throws BusinessException {
        for (Direction e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        throw new BusinessException("There is no direction like this label : "+label);
    }
}
