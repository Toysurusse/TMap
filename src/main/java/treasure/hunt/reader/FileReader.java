package treasure.hunt.reader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import treasure.hunt.business.init.InitMap;
import treasure.hunt.config.ConfigurationMap;
import treasure.hunt.entity.MapTreasure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * This service allow you to read the input file
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class FileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    @Value("${env.config.path}")
    Resource resourceFile;

    @Autowired
    InitMap initMap;

    @Autowired
    ConfigurationMap configurationMap;

    /**
     * Read the file from input file, and create the mapTreasure in ConfigurationMap
     */
    public void readFile() {
        try {
            File file = resourceFile.getFile();
            Scanner myReader = new Scanner(file);
            StringBuilder fileInfo = new StringBuilder("");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileInfo.append(data + "\n");
            }
            myReader.close();
            configurationMap.setMapTreasure(initMap.getItemFromLines(fileInfo.toString()));
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not found.");
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("An error has occured.");
            e.printStackTrace();
        }
    }


}
