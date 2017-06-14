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
public class SimpleDirectorySynchronizerV3 extends BaseSimpleDirectorySynchronizer {
    private static Logger logger = Logger.getLogger(SimpleDirectorySynchronizerV3.class.getName());

    @Autowired
    private File sourceDirectory;
    @Autowired
    private File destinationDirectory;

    {
        logger.info("Using field injection");
    }

    public File getSourceDirectory() {
        return sourceDirectory;
    }

    public File getDestinationDirectory() {
        return destinationDirectory;
    }
}