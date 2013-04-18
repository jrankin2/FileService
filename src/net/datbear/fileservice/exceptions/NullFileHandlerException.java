package net.datbear.fileservice.exceptions;

/**
 * @author Joe
 */
public class NullFileHandlerException extends FileServiceException{
    public NullFileHandlerException(){
        super("Cannot read/write with null reader/writer");
    }
}
