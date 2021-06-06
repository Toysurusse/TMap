package treasure.hunt.entity.eunmeration;


/**
 * Enum of moveResult
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public enum MoveResult {

    NA(Orientation.N, Direction.A, -1, 0, Orientation.N),
    NR(Orientation.N, Direction.R, 1, 0, Orientation.N),
    ND(Orientation.N, Direction.D, 0, 0, Orientation.E),
    NG(Orientation.N, Direction.G, 0, 0, Orientation.O),

    SA(Orientation.S, Direction.A, 1, 0, Orientation.S),
    SR(Orientation.S, Direction.R, -1, 0, Orientation.S),
    SD(Orientation.S, Direction.D, 0, 0, Orientation.O),
    SG(Orientation.S, Direction.G, 0, 0, Orientation.E),

    OA(Orientation.O, Direction.A, 0, -1, Orientation.O),
    OR(Orientation.O, Direction.R, 0, 1, Orientation.O),
    OD(Orientation.O, Direction.D, 0, 0, Orientation.N),
    OG(Orientation.O, Direction.G, 0, 0, Orientation.S),

    EA(Orientation.E, Direction.A, 0, 1, Orientation.E),
    ER(Orientation.E, Direction.R, 0, -1, Orientation.E),
    ED(Orientation.E, Direction.D, 0, 0, Orientation.S),
    EG(Orientation.E, Direction.G, 0, 0, Orientation.N);

    public final int MOVEX;
    public final int MOVEY;
    public final Orientation orientation;
    public final Orientation orientationResult;
    public final Direction direction;

    private MoveResult(Orientation orientation, Direction direction, int moveX, int moveY, Orientation orientationResult) {
        this.orientation = orientation;
        this.direction = direction;
        this.MOVEX = moveX;
        this.MOVEY = moveY;
        this.orientationResult = orientationResult;
    }

    /**
     * function to get enum from orientation and direction. This enum define the result of the orientation and the direction instructions
     *
     * @param orientation orientation of adventurer
     * @param direction direction of values
     * @return Direction default is a plain
     */
    public static MoveResult valueOfLabel(Orientation orientation, Direction direction) {
        for (MoveResult e : values()) {
            if (e.orientation == orientation && e.direction == direction) {
                return e;
            }
        }
        return null;
    }
}
