/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datbear.fileservice.impl;

import java.util.List;
import net.datbear.fileservice.FormatStrategy;

/**
 * Provides a way to not format text files when using FileService.
 * @author Joe Rankin
 */
public class NullTextFormatter implements FormatStrategy<String, String> {

    @Override
    public List<String> encode(List<String> data) {
        return data;
    }

    @Override
    public List<String> decode(List<String> data) {
        return data;
    }
    
}
