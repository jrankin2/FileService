/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datbear.fileservice;

import java.io.IOException;
import java.util.List;
import net.datbear.fileservice.exceptions.NullFileHandlerException;
import net.datbear.fileservice.exceptions.NullFormatterException;

/**
 * FileService<EnodedObject,DecodedObject>
 *
 * File service that reads and writes to files using the specified formatters.
 * Generics ensure that data is being encoded/decoded to/from the same types...
 *
 * FileReaderFormat and FileWriterFormat can be null if reading/writing is not
 * needed. isReadable() and isWritable() return whether FileService will be able
 * to attempt to read/write respectively.
 * 
 * All exceptions thrown within this class (*should*) extend FileServiceException
 * 
 * @author Joe Rankin
 */
public class FileService<E, D> {//<EncodedFormat, DecodedFormat>//viable?

    FileReaderStrategy<E> fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy<E> fileWriter;//TextFileWriter/BinaryFileWriter
    DecoderStrategy<E, D> fileReaderFormat;
    EncoderStrategy<E, D> fileWriterFormat;

    public FileService(FileHandlerStrategy<E> fileHandler, FormatStrategy<E, D> format) {
        setFileReader(fileHandler);
        setFileWriter(fileHandler);
        setFileReaderFormat(format);
        setFileWriterFormat(format);
    }

    public FileService(FileReaderStrategy<E> fileReader,
            FileWriterStrategy<E> fileWriter,
            DecoderStrategy<E, D> fileReaderFormat,
            EncoderStrategy<E, D> fileWriterFormat) {
        setFileReader(fileReader);
        setFileWriter(fileWriter);
        setFileReaderFormat(fileReaderFormat);
        setFileWriterFormat(fileWriterFormat);
    }

    /**
     * Writes to a file given a List containing objects to encode or file lines
     *
     * @param objects list of objects to encode/write to file
     * @return success boolean
     * @throws IOException upon write error
     * @throws NullFileHandlerException when fileWriter is null
     * @throws NullFormatterException when fileWriterFormat is null
     */
    public final boolean writeFile(List<D> objects) throws IOException, NullFileHandlerException, NullFormatterException {
        if (isWriteable() && fileWriterFormat != null) {
            List<E> encodedLines = fileWriterFormat.encode(objects);
            return fileWriter.writeFile(encodedLines);
        } else {
            if (isWriteable()) {
                throw new NullFormatterException();
            } else {
                throw new NullFileHandlerException();
            }
        }
    }
    /**
     * Writes to a file without the use of an encoder/formatter.
     * @param objects list of encoded objects
     * @return success boolean
     * @throws IOException upon write error
     * @throws NullFileHandlerException if fileWriter is null
     */
    public final boolean writeUnformattedFile(List<E> objects) throws IOException, NullFileHandlerException {
        if (isWriteable()) {
            return fileWriter.writeFile(objects);
        } else {
            throw new NullFileHandlerException();
        }
    }

    /**
     * Reads from a file and decodes it to a List containing decoded objects.
     * @return List of decoded objects from the file.
     * @throws IOException upon file read error
     * @throws NullFileHandler when fileReader is null
     */
    public final List<D> readFile() throws IOException, NullFormatterException, NullFileHandlerException {
        if (isReadable() && fileReaderFormat != null) {
            List<E> fileLines = fileReader.readFile();
            return fileReaderFormat.decode(fileLines);
        } else {
            if (isReadable()) {
                throw new NullFormatterException();
            } else {
                throw new NullFileHandlerException();
            }
        }
    }
    
    /**
     * Reads a file without the use of a decoder/formatter.
     * @return List of encoded objects from a file.
     * @throws IOException upon file read error
     * @throws NullFileHandlerException  if fileReader is null
     */
    public final List<E> readUnformattedFile() throws IOException, NullFileHandlerException {
        if (isReadable()) {
            return fileReader.readFile();
        } else {
            throw new NullFileHandlerException();
        }
    }
    
    /**
     * Encodes a List of decoded objects.
     * @param data List of encoded objects
     * @return List of decoded objects
     * @throws NullFormatterException if fileWriterFormat is null
     */
    public final List<E> encode(List<D> data) throws NullFormatterException {
        if (fileWriterFormat == null) {
            throw new NullFormatterException();
        }
        return fileWriterFormat.encode(data);
    }
    
    /**
     * Decodes a List of encoded objects.
     * @param data List of decoded objects
     * @return List of encoded objects
     * @throws NullFormatterException if fileReaderFormat is null
     */
    public final List<D> decode(List<E> data) throws NullFormatterException {
        if (fileReaderFormat == null) {
            throw new NullFormatterException();
        }
        return fileReaderFormat.decode(data);
    }

    public final FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public final void setFileReader(FileReaderStrategy<E> fileReader) {
        this.fileReader = fileReader;
    }

    public final FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public final void setFileWriter(FileWriterStrategy<E> fileWriter) {
        this.fileWriter = fileWriter;
    }

    public final DecoderStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    public final void setFileReaderFormat(DecoderStrategy<E, D> fileReaderFormat) {
        this.fileReaderFormat = fileReaderFormat;
    }

    public final EncoderStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    public final void setFileWriterFormat(EncoderStrategy<E, D> fileWriterFormat) {
        this.fileWriterFormat = fileWriterFormat;
    }

    public final void setAppend(boolean append) {
        fileWriter.setAppend(append);
    }

    public final boolean doesAppend() {
        return fileWriter.doesAppend();
    }

    public final boolean isWriteable() {
        return fileWriter != null;
    }

    public final boolean isReadable() {
        return fileReader != null;
    }
}
