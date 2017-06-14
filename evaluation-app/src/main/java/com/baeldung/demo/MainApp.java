package com.baeldung.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.File;

/**
 * Created by elyor on 27.05.2017.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class MainApp {
    @Value("${source.dir}")
    private String sourceDirectoryPath;

    @Value("${destination.dir}")
    private String destinationDirectoryPath;

    @Bean(name = "sourceDirectory")
    public File getSourceDirectory() {
        return new File(sourceDirectoryPath);
    }

    @Bean(name = "destinationDirectory")
    public File getDestinationDirectory() {
        return new File(destinationDirectoryPath);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        //All v1,v2,v3 versions of synchronizer do the same thing, so let's just use v1 here
        SimpleDirectorySynchronizerV1 synchronizerV1 = context.getBean(SimpleDirectorySynchronizerV1.class);
        synchronizerV1.run();
    }
}
