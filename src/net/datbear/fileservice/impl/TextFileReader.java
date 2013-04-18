package net.datbear.fileservice.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.*;

/**
 * @author Joe
 */
public class TextFileReader implements FileReaderStrategy<String> {

    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readFile() throws IOException {
        List lines = new ArrayList();
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new FileReader(filePath));
            String line = in.readLine();
            while (line != null) {
                lines.add(line);
                line = in.readLine();
            }
        } catch(IOException ioe){
            throw ioe;
        }finally{
            if(in != null){
                in.close();
            }
        }
        
        return lines;
    }

    //helper method
    public static List readFile(String filePath) throws IOException {
        return new TextFileReader(filePath).readFile();
    }
}
