package com.baeldung.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by elyor on 11.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = SimpleDirectorySynchronizerV1.class)
@ContextConfiguration(classes = SimpleDirectorySynchronizerV1UnitTest.class)
public class SimpleDirectorySynchronizerV1UnitTest {
    @Autowired
    private SimpleDirectorySynchronizerV1 synchronizerV1;

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
        File sourceDir = synchronizerV1.getSourceDirectory();

        assertNotNull(sourceDir);
        assertEquals(sourceDir.getPath(), "source-dir");
    }

    @Test
    public void givenSynchronizerAutowiredWithDirectories_whenGetterOfDestinationDirectoryInvoked_thenReturnsTheInjectedDestinationDirectory() throws Exception {
        File destDir = synchronizerV1.getDestinationDirectory();

        assertNotNull(destDir);
        assertEquals(destDir.getPath(), "destination-dir");
    }

}