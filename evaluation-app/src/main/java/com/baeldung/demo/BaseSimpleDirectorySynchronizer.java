package com.baeldung.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by elyor on 14.06.2017.
 */
public abstract class BaseSimpleDirectorySynchronizer implements Runnable {

    public abstract File getSourceDirectory();

    public abstract File getDestinationDirectory();

    public void run() {
        File sourceDir = getSourceDirectory();
        File destDir = getDestinationDirectory();
        File[] filesToCopy = sourceDir.listFiles();

        for (File file : filesToCopy) {
            try {
                Files.copy(file.toPath(), destDir.toPath());
            } catch (IOException e) {
                System.out.println("Couldn't copy " + file.getName()
                        + " from " + sourceDir.getAbsolutePath()
                        + " to " + destDir.getAbsolutePath());
            }
        }
    }
}