package treasure.hunt.business.move;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.MapItems;
import treasure.hunt.entity.eunmeration.MoveResult;
import treasure.hunt.entity.eunmeration.Orientation;

@Service
public class MoveAdventurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveAdventurer.class);

    public static Adventurer moveAdventurer(MapTreasure mapTreasure, Adventurer adventurer) {
        LOGGER.info(adventurer.toString());
        MoveResult moveResult = getMoveResult(adventurer.getMoves().get(0), adventurer.getOrientation());
        LOGGER.info(moveResult.orientationResult.label+ moveResult.direction.label+ moveResult.MOVEX+ moveResult.MOVEY);
        Position nextPosition = getNextPosition(adventurer.getPosition(), moveResult);
        LOGGER.info(nextPosition.toString());
        LOGGER.info("result : "+isNextPositionAllowed(mapTreasure.getWidth(), mapTreasure.getHeigth(), nextPosition));
        if (isNextPositionAllowed(mapTreasure.getWidth(), mapTreasure.getHeigth(), nextPosition)) {
            LOGGER.debug(mapTreasure.getMapItems().toString());
            MapItem mapItem = mapTreasure.getItemFromMap(nextPosition.getPositionX(), nextPosition.getPositionY());
            switch (MapItems.valueOfLabel(mapItem.getName())) {
                case MOUNTAINS:
                    LOGGER.info("this move is not allowed and will be ignored because we can't climb mountains");
                    deleteMove(adventurer);
                    break;
                case ADVENTURER:
                    if(isSamePosition(adventurer, mapItem.getPosition())){
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

    private static boolean isSamePosition(Adventurer adventurer, Position isSamePosition) {
        return isSamePosition.getPositionX() != adventurer.getPosition().getPositionX()
                || isSamePosition.getPositionY() != adventurer.getPosition().getPositionY();
    }

    private static void getTreasureAndMove(MapTreasure mapTreasure, Adventurer adventurer, Position nextPosition, Treasure treasure, Orientation orientation) {
        if(isSamePosition(adventurer, nextPosition))mapTreasure.handleTreasure(treasure, adventurer, nextPosition);
        move(mapTreasure, adventurer, nextPosition, orientation);
    }

    private static void move(MapTreasure mapTreasure, Adventurer adventurer, Position nextPosition, Orientation orientation) {
        mapTreasure.setNewPositionForAdventurer(adventurer, nextPosition, orientation);
    }

    private static void deleteMove(Adventurer adventurer) {
        try {
            adventurer.deleteMove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isNextPositionAllowed(int width, int heigth, Position nextPosition) {
        LOGGER.info("W : " + width + " | H : " + heigth + " | NewPosition : " + nextPosition.toString());
        if (nextPosition.getPositionX()>=0 && nextPosition.getPositionY()>=0 && nextPosition.getPositionX() < width && nextPosition.getPositionY() < heigth) return true;
        return false;
    }

    private static Position getNextPosition(Position position, MoveResult moveResult) {
        return new Position(position.getPositionX() + moveResult.MOVEX, position.getPositionY() + moveResult.MOVEY);
    }
    private static MoveResult getMoveResult(Direction direction, Orientation orientation) {
        return MoveResult.valueOfLabel(orientation, direction);
    }
}
