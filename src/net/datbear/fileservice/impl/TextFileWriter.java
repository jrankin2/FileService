package net.datbear.fileservice.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import net.datbear.fileservice.FileType;
import net.datbear.fileservice.FileWriterStrategy;

/**
 * Writes text files given a list of objects.
 * @author Joe
 */
public class TextFileWriter implements FileWriterStrategy<String> {
    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;
    private boolean append;

    public TextFileWriter(String filePath, boolean append) {
        this.filePath = filePath;
        this.append = append;
    }

    @Override
    public boolean writeFile(List objects) throws IOException {
        PrintWriter out = null;
        try{
            out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(filePath, append)));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objects.size(); i++) {
            sb.append(objects.get(i));
            if(i != objects.size()-1) sb.append("\n");//if not last line, add a new one
        }
        out.print(sb.toString());
        
        return true;
        } catch(IOException ioe){
            throw ioe;
        } finally{
            if(out != null){
                out.close();
            }
            return false;
        }
        
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
