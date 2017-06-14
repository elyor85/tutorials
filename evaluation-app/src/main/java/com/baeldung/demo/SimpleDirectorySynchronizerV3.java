package com.baeldung.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by elyor on 27.05.2017.
 */
@Component
public class SimpleDirectorySynchronizerV3 extends BaseSimpleDirectorySynchronizer {
    @Autowired
    private File sourceDirectory;
    @Autowired
    private File destinationDirectory;

    {
        System.out.println("Using field injection");
    }

    public File getSourceDirectory() {
        return sourceDirectory;
    }

    public File getDestinationDirectory() {
        return destinationDirectory;
    }
}