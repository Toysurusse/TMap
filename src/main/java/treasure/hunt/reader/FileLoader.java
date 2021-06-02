package treasure.hunt.reader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Load input file from resources/data.
 *
 * @author Max LB (@Toysurusse)
 */
public class FileLoader {

    /**
     * Load input file from resources/data/inputFile.txt.
     */
    @Value("classpath:data/inputFile.txt")
    Resource resourceFile;

    public Resource getResourceFile() {
        return resourceFile;
    }

    public void setResourceFile(Resource resourceFile) {
        this.resourceFile = resourceFile;
    }
}
