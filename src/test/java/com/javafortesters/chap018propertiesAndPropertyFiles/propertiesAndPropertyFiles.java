package com.javafortesters.chap018propertiesAndPropertyFiles;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class propertiesAndPropertyFiles {
    @Test
    public void learnProperties(){
        Properties properties = new Properties();
        assertThat(properties.size(), is(0));

        properties.setProperty("browser", "chrome");
        properties.setProperty("port", "80");

        assertThat(properties.getProperty("browser"), is("chrome"));
        assertThat(properties.getProperty("nothing"), is(CoreMatchers.<String>nullValue()));
        assertThat(properties.getProperty("non exist", "default"), is("default"));

        for(String key : properties.stringPropertyNames()){
            System.out.println("Key: "+ key + " " + "Value: " + properties.getProperty(key));
        }

        properties.list(System.out);

        assertThat(properties.containsKey("browser"), is(true));
    }

    @Test
    public void createAndListAProperties() {
        Properties ppt = new Properties();
        ppt.setProperty("name", "bob");
        ppt.setProperty("gender", "male");
        ppt.setProperty("password", "paSSw0rd");

        assertThat(ppt.size(), is(3));

        for(String key : ppt.stringPropertyNames()){
            System.out.println("Key: " + key + " " + "Value: " + ppt.get(key));
        }

        ppt.list(System.out);

        assertThat(ppt.containsKey("gender"), is(true));
        assertThat(ppt.getProperty("name"), is("bob"));

        assertThat(ppt.getProperty("permission", "Admin"), is("Admin"));

        System.out.println(System.getProperty("user.dir"));

        Properties sys = System.getProperties();

        System.out.println(sys.getProperty("java.home"));
    }

    @Test
    public void storeNewPropToPropertiesFile() throws IOException {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = new File(tempDirectory, "tempFileForPropertiesStoreTest.properties").getAbsolutePath();
        System.out.println(tempResourceFilePath);

        Properties saved = new Properties();
        saved.setProperty("prop1", "Hello");
        saved.setProperty("prop2", "World");

        FileOutputStream outputFile = new FileOutputStream(tempResourceFilePath);
        saved.store(outputFile, "Hello There World");
        outputFile.close();

        FileReader propertyFileReader = new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();

        try{
            loaded.load(propertyFileReader);
        } finally{
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("prop1"), is("Hello"));
        assertThat(loaded.getProperty("prop2"), is("World"));
    }
}
