package net.datbear.fileservice;

import java.io.IOException;
import java.util.List;

/**
 * Defines a file reading strategy
 * @author jrankin2
 */
public interface FileReaderStrategy<T> {
    public abstract List<T> readFile() throws IOException;
}
