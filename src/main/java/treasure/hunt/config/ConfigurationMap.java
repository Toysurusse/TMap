package treasure.hunt.config;

import org.springframework.stereotype.Service;
import treasure.hunt.entity.MapTreasure;


/**
 * Static map shared in all the application
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class ConfigurationMap {

    private static MapTreasure mapTreasure;

    public static MapTreasure getMapTreasure() {
        return mapTreasure;
    }

    public static void setMapTreasure(MapTreasure mapTreasure) {
        ConfigurationMap.mapTreasure = mapTreasure;
    }
}
