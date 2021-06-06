package treasure.hunt.config;

import org.springframework.stereotype.Service;
import treasure.hunt.entity.MapTreasure;

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
