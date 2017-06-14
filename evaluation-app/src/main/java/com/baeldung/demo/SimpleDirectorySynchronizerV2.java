package com.baeldung.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

/**
 * Created by elyor on 27.05.2017.
 */
@Component
@Lazy
public class SimpleDirectorySynchronizerV2 extends BaseSimpleDirectorySynchronizer {
    private static Logger logger = Logger.getLogger(SimpleDirectorySynchronizerV2.class.getName());

    private File sourceDirectory;
    private File destinationDirectory;

    @Autowired
    public void setSourceDirectory(File sourceDirectory) {
        logger.info("Using method/setter injection: sourceDirectory)");
        this.sourceDirectory = sourceDirectory;
    }

    @Autowired
    public void setDestinationDirectory(File destinationDirectory) {
        logger.info("Using method/setter injection: destinationDirectory)");
        this.destinationDirectory = destinationDirectory;
    }

    public File getSourceDirectory() {
        return sourceDirectory;
    }

    public File getDestinationDirectory() {
        return destinationDirectory;
    }
}