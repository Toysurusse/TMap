package treasure.hunt.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;
import treasure.hunt.entity.eunmeration.OrientationTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdventurerTest {

    private Adventurer adventurer;

    @Before
    public void init(){
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.D);
        adventurer = new Adventurer("name", new Position(1,2), Orientation.N, directions );
    }

    @Test
    public void constructor(){
        Assert.assertTrue(adventurer.getNameAdventurer().equals("name"));
        Assert.assertTrue(adventurer.getPosition().getPositionX()==1);
        Assert.assertTrue(adventurer.getPosition().getPositionY()==2);
        Assert.assertTrue(adventurer.getOrientation()== Orientation.N);
        Assert.assertTrue(adventurer.getMoves().get(0)== Direction.D);
    }

}
