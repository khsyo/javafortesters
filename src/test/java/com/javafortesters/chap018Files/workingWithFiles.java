package com.javafortesters.chap018Files;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class workingWithFiles {
    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(
                                new BufferedWriter(
                                    new FileWriter(outputFile)));

        for(int lineNumber = 1; lineNumber < 6; lineNumber++){
            print.println("line" + lineNumber);
        }

        print.close();
        return outputFile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {
        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try{
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally{
            reader.close();
        }

        Properties properties = new Properties();
        properties.list(System.out);
    }

    @Test
    public void createATempFileAndVaryTheParameters() throws  IOException {
        Properties sys = System.getProperties();

        File outputFile = File.createTempFile("temp", null, new File(System.getProperty("user.dir")));
        PrintWriter print = new PrintWriter(
                                new BufferedWriter(
                                        new FileWriter(outputFile)
                                )
        );
        for(int line = 1; line < 6; line++){
            print.println("line " + line);
        }
        print.close();

        assertThat(outputFile.exists(), is(true));
        assertThat(outputFile.length(), is(35L));

        outputFile.deleteOnExit();
    }

    @Test
    public void writeOutTheFileListRoots(){
        File[] roots = File.listRoots();

        assertTrue(roots.length > 0);

        for(File aFile : roots){
            System.out.println(aFile.getAbsoluteFile());
        }

        assertTrue("Unrecognised OS file separator",
                File.separator.equals("\\") ||
                        File.separator.equals("/"));

    }

    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {
        File output = new File(System.getProperty("user.dir")+ "/newFileThatDoesNotExists.txt");

        assertThat(output.exists(), is(false));

        output.createNewFile();
        assertThat(output.exists(), is(true));

        output.delete();
        assertThat(output.exists(), is(false));

        File output2 = new File(System.getProperty("java.io.tmpdir") + System.currentTimeMillis());

        output2.createNewFile();

        assertThat(output2.exists(), is(true));

        assertThat(output.getParent(), is("newFileThatDoesNotExists.txt"));
    }

    @Test
    public void useGetCanonicalPath() throws IOException {
        File output = new File(System.getProperty("user.dir") + "/../javafortester", "/newFile.txt");
        assertThat(output.getCanonicalPath(), is("/Users/hesong/Documents/javafortester/newFile.txt"));
        assertThat(output.getAbsolutePath(), is("/Users/hesong/Documents/javafortester/newFile.txt"));
    }

    @Test
    public void testMkdir() throws IOException {
        File aDirectory = new File(System.getProperty("java.io.tmpdir"));

        assertThat(aDirectory.isDirectory(), is(true));
        assertThat(aDirectory.isFile(), is(false));
    }

    @Test
    public void writeToAPrintWriterThenAppend() throws IOException {
        File outputFile = File.createTempFile("output", null);
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);

        print.println("this is the first line");
        print.close();

        writer = new FileWriter(outputFile, true);
        buffer = new BufferedWriter(writer);
        print = new PrintWriter(buffer);
        print.println("New line after append");
        print.close();

        String lineEnd = System.lineSeparator();
        long fileLen = 43L + lineEnd.length() + lineEnd.length();
        assertThat( outputFile.length(), is(fileLen));
        long tempSpace = outputFile.getFreeSpace();
        long tempLength = outputFile.length();
        long totalSpace = outputFile.getTotalSpace();
        assertThat(totalSpace, is(tempSpace + tempLength));

    }

    @Test
    public void createAFileAndCalculateTheLength() throws IOException{
        File temp = new File(System.getProperty("java.io.tmpdir"));
        long freeSpace = temp.getFreeSpace();
        long usableSpace = temp.getUsableSpace();
        long totalSpace = temp.getTotalSpace();

        File outputFile = writeTheTestDataFile(5);

        System.out.println("Length " + outputFile.length());
        System.out.println("Free " + freeSpace);
        System.out.println("Usable " + usableSpace);
        System.out.println("Total " + totalSpace);

        assertThat(outputFile.length(), is(expectedFileSize(5)));

    }

    private long expectedFileSize(int lines){
        String lineEnd = System.lineSeparator();
        return (("line x".length() + lineEnd.length()) * lines );
    }

    private File writeTheTestDataFile(int lines) throws IOException{
        File outputFile = File.createTempFile("forReading" + lines + "_", null);

        PrintWriter print = new PrintWriter(
                                new BufferedWriter(
                                        new FileWriter(outputFile)
                                )
        );

        for(int line = 0; line < lines; line++) {
            print.println("line " + lines);
        }
        print.close();
        return outputFile;
    }

    @Test
    public void useListFilesToShowTheTempDirectoryContents() {
        File temp = new File(System.getProperty("java.io.tmpdir"));
        File[] tempListFile = temp.listFiles();

        for (File file : tempListFile){
            String outputString = "";
            if(file.isDirectory()){
                outputString = outputString + "DIR ";
            }
            if(file.isFile()){
                outputString = outputString + "FIL ";
            }

            if(file.canRead()){
                outputString+= "r";
            } else {
                outputString+= "-";
            }

            if(file.canWrite()){
                outputString+= "w";
            } else {
                outputString+= "-";
            }

            if(file.canExecute()){
                outputString+= "e";
            } else {
                outputString+= "-";
            }

            SimpleDateFormat sdf = new SimpleDateFormat("y M d HH:mm:ss.SSS");
            String lastModified = sdf.format(new Date(file.lastModified()));

            outputString = outputString + "=>" + lastModified;

            System.out.println(outputString);
        }


    }
}
