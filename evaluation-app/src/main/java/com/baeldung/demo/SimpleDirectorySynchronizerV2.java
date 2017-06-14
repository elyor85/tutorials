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
public class SimpleDirectorySynchronizerV2 extends BaseSimpleDirectorySynchronizer {
    private File sourceDirectory;
    private File destinationDirectory;

    @Autowired
    public void setSourceDirectory(File sourceDirectory) {
        System.out.println("Using method/setter injection: sourceDirectory)");
        this.sourceDirectory = sourceDirectory;
    }

    @Autowired
    public void setDestinationDirectory(File destinationDirectory) {
        System.out.println("Using method/setter injection: destinationDirectory)");
        this.destinationDirectory = destinationDirectory;
    }

    public File getSourceDirectory() {
        return sourceDirectory;
    }

    public File getDestinationDirectory() {
        return destinationDirectory;
    }
}