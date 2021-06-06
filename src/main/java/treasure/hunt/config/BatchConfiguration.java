package treasure.hunt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import treasure.hunt.business.move.MoveAdventurer;
import treasure.hunt.business.move.MoveOrchestor;
import treasure.hunt.reader.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public FileReader fileReader;

    @Autowired
    public ConfigurationMap configurationMap;

    @Autowired
    public MoveOrchestor moveOrchestor;

    @Value("classpath:data/inputFile.txt")
    Resource resourceFile;

    @Bean
    public void reader() {
        this.fileReader.readFile();
        LOGGER.info(configurationMap.getMapTreasure().toString());
        this.moveOrchestor.moveAdneturers();
    }

    @Bean
    public void writer() {

    }
}