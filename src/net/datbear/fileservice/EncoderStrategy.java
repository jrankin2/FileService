
package net.datbear.fileservice;

import java.util.List;

public interface EncoderStrategy<E, D> {
    /**
     * Takes a List of DecodedObjects and encodes it to a List of EncodedObjects.
     * @param data List of DecodedObjects to encode
     * @return List of EncodedObjects (e.g. Strings in the case of file handling)
     */
    public abstract List<E> encode(List<D> data);//
    
}
