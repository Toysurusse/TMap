package treasure.hunt.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treasure.hunt.config.ConfigurationMap;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


/**
 * Service to write result of the program in an external file
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@Service
public class FilerWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilerWriter.class);

    @Autowired
    ConfigurationMap configurationMap;

    /**
     * write the file in the output file after moving all adventurers
     */
    public void writeFile(){
        LOGGER.info(configurationMap.getMapTreasure().toFileString().toString());
        try {
            Files.write(Paths.get("src/main/resources/result/Output"+
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("-dd-MM-yyyy-"))+".txt"),
                            configurationMap.getMapTreasure().toFileString(),
                            StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
