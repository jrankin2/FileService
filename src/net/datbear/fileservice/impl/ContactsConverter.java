package net.datbear.fileservice.impl;

import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.*;

/**
 *
 * @author Joe
 */
public class ContactsConverter implements FormatStrategy<String, Contact>{

    @Override
    public List<String> encode(List<Contact> data) {
        List<String> encodedData = new ArrayList<String>();
        
        for (Contact contact : data) {
            encodedData.add(contact.toString());
        }
        
        return encodedData;
    }

    @Override
    public List<Contact> decode(List<String> data) {
        List<Contact> contacts = new ArrayList<Contact>();
        for (String line : data) {
            String[] fields = line.split("\\|");
            if(fields.length != 8){
                throw new UnsupportedOperationException(
                        "Contact has incorrect number of fields: "+ fields.length);
            }
            
            contacts.add(new Contact(fields[0], 
                    fields[1],
                    fields[2],
                    fields[3],
                    fields[4],
                    fields[5],
                    fields[6],
                    fields[7]));
        }
        return contacts;
    }
    
    
    
}
