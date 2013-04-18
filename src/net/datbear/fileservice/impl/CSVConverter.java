package net.datbear.fileservice.impl;

import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.FormatStrategy;

/**
 * @author Joe
 */
public class CSVConverter implements FormatStrategy<String, String[]>{
    
    private static final char COL_DELIMITER = ',';
    private static final String COL_DELIMITER_STR = ",";
    
    public CSVConverter(){
    }
    
    
    @Override
    public List<String> encode(List<String[]> data) {
        List<String> encodedLines = new ArrayList();
        StringBuilder sb;
        
        for (String[] lineCSVData : data) {
            sb = new StringBuilder();
            for(int i = 0; i < lineCSVData.length; i++) {
                sb.append(lineCSVData[i]);
                if(i != lineCSVData.length - 1) sb.append(COL_DELIMITER);
            }
            encodedLines.add(sb.toString());
        }
        
        return encodedLines;
    }
    
    /**
     * Decode a List containing CSV records (file lines) into a list of String[]s.
     * 
     * @param data List containing file lines as Strings
     * @return List of String[]s containing CSV data fields
     */
    @Override
    public List<String[]> decode(List<String> data) {
        String lineData[];
        List<String[]> fileLineData = new ArrayList<String[]>();
        
        for (String line : data) {
            lineData = line.split(COL_DELIMITER_STR);//String.valueOf(COL_DELIMITER));//<-- would be preformed -a lot-, just give it a var
            fileLineData.add(lineData);
        }
        
        return fileLineData;
    }
}
