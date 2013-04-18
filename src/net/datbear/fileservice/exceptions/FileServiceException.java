package net.datbear.fileservice.exceptions;

/**
 * All Exceptions thrown from the file service should extend this class. This 
 * allows FileServiceException to be a catch-all for catching FileService exceptions.
 * 
 * @author Joe
 */
public class FileServiceException extends RuntimeException{
    public FileServiceException(){
        super("FileService: Error has occurred.");
    }
    
    public FileServiceException(String msg){
        super(msg);
    }
}
