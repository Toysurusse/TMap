package treasure.hunt.business.move;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.MapItems;
import treasure.hunt.entity.eunmeration.MoveResult;
import treasure.hunt.entity.eunmeration.Orientation;

/**
 * Move an adventurer
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class MoveAdventurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveAdventurer.class);

    /**
     * function to let adventurer try to move
     *
     * @param mapTreasure input the tresure map
     * @param adventurer  input the adventer who you want to move
     * @return adventurer result after movement
     */
    public static Adventurer moveAdventurer(MapTreasure mapTreasure, Adventurer adventurer) {
        LOGGER.info(adventurer.toString());
        MoveResult moveResult = getMoveResult(adventurer.getMoves().get(0), adventurer.getOrientation());
        LOGGER.info(moveResult.orientationResult.label + moveResult.direction.label + moveResult.MOVEX + moveResult.MOVEY);
        Position nextPosition = getNextPosition(adventurer.getPosition(), moveResult);
        if (isNextPositionAllowed(mapTreasure.getWidth(), mapTreasure.getHeigth(), nextPosition)) {
            LOGGER.debug(mapTreasure.getMapItems().toString());
            MapItem mapItem = mapTreasure.getItemFromMap(nextPosition.getPositionX(), nextPosition.getPositionY());
            switch (MapItems.valueOfLabel(mapItem.getName())) {
                case MOUNTAINS:
                    LOGGER.info("this move is not allowed and will be ignored because we can't climb mountains");
                    deleteMove(adventurer);
                    break;
                case ADVENTURER:
                    if (isOtherPosition(adventurer, mapItem.getPosition())) {
                        LOGGER.info("this move is not allowed and will be ignored because we can't climb adventurers");
                        deleteMove(adventurer);
                    } else {
                        move(mapTreasure, adventurer, nextPosition, moveResult.orientationResult);
                    }
                    break;
                case TREASURE:
                    getTreasureAndMove(mapTreasure, adventurer, nextPosition, (Treasure) mapItem, moveResult.orientationResult);
                    break;
                case PLAIN:
                    move(mapTreasure, adventurer, nextPosition, moveResult.orientationResult);
                    break;
            }
        } else {
            deleteMove(adventurer);
            LOGGER.error("this move is OutOfBound and will be ignored");
        }
        LOGGER.info(adventurer.toString());
        return adventurer;
    }

    /**
     * Check if the the adventurer move during his turn
     *
     * @param adventurer
     * @param isSamePosition
     * @return boolean <i>true</i> if the adventurer change position, <i>false</i> otherwhise
     */
    private static boolean isOtherPosition(Adventurer adventurer, Position isSamePosition) {
        return isSamePosition.getPositionX() != adventurer.getPosition().getPositionX()
                || isSamePosition.getPositionY() != adventurer.getPosition().getPositionY();
    }

    /**
     * handle treasure keeping and move adventurer
     *
     * @param mapTreasure  the map
     * @param adventurer   adventurer who move
     * @param nextPosition next position of the adventurer
     * @param treasure     tresure on the next position case
     * @param orientation  orientation of adventurer
     */
    private static void getTreasureAndMove(MapTreasure mapTreasure, Adventurer adventurer, Position nextPosition, Treasure treasure, Orientation orientation) {
        if (isOtherPosition(adventurer, nextPosition)) mapTreasure.handleTreasure(treasure, adventurer);
        move(mapTreasure, adventurer, nextPosition, orientation);
    }

    /**
     * move adventurer
     *
     * @param mapTreasure  the map
     * @param adventurer   adventurer who move
     * @param nextPosition next position of the adventurer
     * @param orientation  orientation of adventurer
     */
    private static void move(MapTreasure mapTreasure, Adventurer adventurer, Position nextPosition, Orientation orientation) {
        mapTreasure.setNewPositionForAdventurer(adventurer, nextPosition, orientation);
    }

    /**
     * Delete the move of the adventurer after his turn
     *
     * @param adventurer adventurer who move
     */
    private static void deleteMove(Adventurer adventurer) {
        adventurer.deleteMove();
    }

    /**
     * check if the next position is allowed => does position exist in map
     *
     * @param width width of the map
     * @param heigth heigth of the map
     * @param nextPosition nextPosition of adventurer
     * @return
     */
    private static boolean isNextPositionAllowed(int width, int heigth, Position nextPosition) {
        LOGGER.info("W : " + width + " | H : " + heigth + " | NewPosition : " + nextPosition.toString());
        if (nextPosition.getPositionX() >= 0 && nextPosition.getPositionY() >= 0 && nextPosition.getPositionX() < width && nextPosition.getPositionY() < heigth)
            return true;
        return false;
    }

    /**
     * calculate the next position
     *
     * @param position position of the adventurer
     * @param moveResult move of the turn
     * @return Position : the next position calculated
     */
    private static Position getNextPosition(Position position, MoveResult moveResult) {
        return new Position(position.getPositionX() + moveResult.MOVEX, position.getPositionY() + moveResult.MOVEY);
    }

    /**
     * calculate the moveResult
     *
     * @param direction direction of the adventurer
     * @param orientation orientation of the adventurer
     * @return MoveResult result after calculation
     */
    private static MoveResult getMoveResult(Direction direction, Orientation orientation) {
        return MoveResult.valueOfLabel(orientation, direction);
    }
}
