package treasure.hunt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import treasure.hunt.business.move.MoveOrchestor;
import treasure.hunt.config.BatchConfiguration;
import treasure.hunt.config.ConfigurationMap;
import treasure.hunt.reader.FileReader;
import treasure.hunt.reader.FilerWriter;

/**
 * Spring Boot main file
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
@SpringBootApplication
public class HuntApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

	public static void main(String[] args) {
		SpringApplication.run(HuntApplication.class, args);
	}

	@Autowired
	public FileReader fileReader;

	@Autowired
	public FilerWriter filerWriter;

	@Autowired
	public ConfigurationMap configurationMap;

	@Autowired
	public MoveOrchestor moveOrchestor;

	@Value("${env.config.path}")
	Resource resourceFile;

	@Value("${env.config}")
	String env;

	/**
	 * read the file, move adventurers and then save file in the resources/result folder
	 */
	@Bean
	public void reader() {
		if(env.equals("dev")){
			this.fileReader.readFile();
			LOGGER.info(configurationMap.getMapTreasure().toString());
			this.moveOrchestor.moveAdneturers();
			this.filerWriter.writeFile();
		}
	}
}
