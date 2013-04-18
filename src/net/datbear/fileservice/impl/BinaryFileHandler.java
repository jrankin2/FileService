/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datbear.fileservice.impl;

import java.io.IOException;
import java.util.List;
import net.datbear.fileservice.FileHandlerStrategy;

/**
 *
 * @author jrankin2
 */
public class BinaryFileHandler implements FileHandlerStrategy {
    private boolean append;
    @Override
    public List readFile() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean writeFile(List objects) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
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
