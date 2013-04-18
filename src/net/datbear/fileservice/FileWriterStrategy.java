package net.datbear.fileservice;

import java.io.IOException;
import java.util.List;

/**
 * Defines a file writing strategy
 * @author jrankin2
 */
public interface FileWriterStrategy<T> {
    public abstract boolean writeFile(List<T> objects) throws IOException;//returns success bool
    
    public abstract void setAppend(boolean append);
    public abstract boolean doesAppend();
}
