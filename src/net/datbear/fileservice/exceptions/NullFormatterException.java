package net.datbear.fileservice.exceptions;

/**
 * @author Joe
 */
public class NullFormatterException extends FileServiceException{
    public NullFormatterException(){
        super("Cannot format with null formatter.");
    }
}
