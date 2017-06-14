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
 * Created by elyor on 12.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = SimpleDirectorySynchronizerV2.class)
@ContextConfiguration(classes = SimpleDirectorySynchronizerV2UnitTest.class)
public class SimpleDirectorySynchronizerV2UnitTest {
    @Autowired
    private SimpleDirectorySynchronizerV2 synchronizerV2;

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
        File sourceDir = synchronizerV2.getSourceDirectory();

        assertNotNull(sourceDir);
        assertEquals(sourceDir.getPath(), "source-dir");
    }

    @Test
    public void givenSynchronizerAutowiredWithDirectories_whenGetterOfDestinationDirectoryInvoked_thenReturnsTheInjectedDestinationDirectory() throws Exception {
        File destDir = synchronizerV2.getDestinationDirectory();

        assertNotNull(destDir);
        assertEquals(destDir.getPath(), "destination-dir");
    }

}