package net.datbear.fileservice;

/**
 * Extends both reader and writer to provide an interface for complete file handler
 * implementations.
 * @author Joe
 */
public interface FileHandlerStrategy<T> extends FileReaderStrategy<T>, FileWriterStrategy<T> {
    
}
