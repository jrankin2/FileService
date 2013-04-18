package net.datbear.fileservice.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.datbear.fileservice.*;
import net.datbear.fileservice.impl.*;

/**
 * Just a class demonstrating the FileService.
 * See also - ContactConversionSample
 * @author jrankin2
 */
public class CSVConversionExample {
    
    public static void main(String[] args) {
        FileReaderStrategy<String> tfr = new TextFileReader("src/fsTest.txt");
        FileWriterStrategy<String> tfw = new TextFileWriter("src/fsTest.txt", false);
        FormatStrategy<String, String[]> csvc = new CSVConverter();
        List<String[]> lines = new ArrayList<String[]>();
        lines.add(new String[] {"hello", "world"});
        lines.add(new String[] {"world", "hello"});
        
        FileService<String, String[]> fs = new FileService<String,String[]>(tfr, tfw, csvc, csvc);
        try{
            if(fs.writeFile(lines)){//if writing was successful
                List<String[]> csvData = fs.readFile();
                for (String[] row : csvData) {
                    System.out.println(Arrays.toString(row));
                }
            }
            
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
    }
    
}
