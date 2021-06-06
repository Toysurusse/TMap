package treasure.hunt.business.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import treasure.hunt.entity.*;
import treasure.hunt.entity.eunmeration.Direction;
import treasure.hunt.entity.eunmeration.Orientation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Initialize the map
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitMapTest {

    InitMap initMap;

    @Test
    public void createMapTreasure(){
        initMap = new InitMap();
        initMap.getItemFromLines(
                "C - 3 - 3\n" +
                "M - 1 - 1\n" +
                "A - test - 2 - 2 - S - ADG\n" +
                "T - 1 - 2 - 2");
    }
}