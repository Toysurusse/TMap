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

@Service
public class FileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    @Value("classpath:data/inputFile.txt")
    Resource resourceFile;

    @Autowired
    InitMap parseData;

    @Autowired
    ConfigurationMap configurationMap;

    public void readFile() {
        try {
            File file = resourceFile.getFile();
            Scanner myReader = new Scanner(file);
            StringBuilder fileInfo = new StringBuilder("<table>\n");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileInfo.append(data + "\n");
                LOGGER.info(data);
            }
            myReader.close();
            configurationMap.setMapTreasure(parseData.getItemFromLines(fileInfo.toString()));
        } catch (FileNotFoundException e) {
            System.out.println("File Not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }


}
