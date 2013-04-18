package net.datbear.fileservice.impl;

import java.io.IOException;
import java.util.List;
import net.datbear.fileservice.FileHandlerStrategy;
import net.datbear.fileservice.FileReaderStrategy;
import net.datbear.fileservice.FileType;
import net.datbear.fileservice.FileWriterStrategy;

/**
 *
 * @author Joe Rankin
 */
public class TextFileHandler implements FileHandlerStrategy<String>{
    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;
    private boolean append;
    private FileReaderStrategy fileReader;
    private FileWriterStrategy fileWriter;
    
    
    public TextFileHandler(String filePath, boolean append) {
        this.filePath = filePath;
        this.append = append;
        fileReader = new TextFileReader(filePath);
        fileWriter = new TextFileWriter(filePath, append);
    }
    
    public TextFileHandler(String filePath){
        this(filePath, true);//on the safe side
    }
    
    @Override
    public List<String> readFile() throws IOException {
        return fileReader.readFile();
    }
    
    //helper method
    public static List<String> readFile(String filePath) throws IOException {
        return new TextFileReader(filePath).readFile();
    }
    
    @Override
    public boolean writeFile(List<String> objects) throws IOException {
        return fileWriter.writeFile(objects);
    }
    
    //helper method
    public static boolean writeFile(String filePath, boolean append, List objects) throws IOException{
        return new TextFileWriter(filePath, append).writeFile(objects);
    }

    @Override
    public void setAppend(boolean append) {
        this.append = append;
    }

    @Override
    public boolean doesAppend() {
        return append;
    }
}
