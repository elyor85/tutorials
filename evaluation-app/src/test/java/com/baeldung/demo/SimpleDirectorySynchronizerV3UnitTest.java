package com.baeldung.demo;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by elyor on 12.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = SimpleDirectorySynchronizerV3.class)
@ContextConfiguration(classes = SimpleDirectorySynchronizerV3UnitTest.class)
public class SimpleDirectorySynchronizerV3UnitTest {
    @Autowired
    private SimpleDirectorySynchronizerV3 synchronizerV3;

    @Bean(name = "sourceDirectory")
    public File getSourceDirectory() {
        return new File("source-dir");
    }

    @Bean(name = "destinationDirectory")
    public File getDestinationDirectory() {
        return new File("destination-dir");
    }

    @Test
    public void givenSynchronizerAutowiredWithDirectories_whenGetterOfSourceDirectoryInvoked_thenReturnsTheInjectedSourceDirectory() throws Exception {
        File sourceDir = synchronizerV3.getSourceDirectory();

        assertNotNull(sourceDir);
        assertEquals(sourceDir.getPath(), "source-dir");
    }

    @Test
    public void givenSynchronizerAutowiredWithDirectories_whenGetterOfDestinationDirectoryInvoked_thenReturnsTheInjectedDestinationDirectory() throws Exception {
        File destDir = synchronizerV3.getDestinationDirectory();

        assertNotNull(destDir);
        assertEquals(destDir.getPath(), "destination-dir");
    }

}