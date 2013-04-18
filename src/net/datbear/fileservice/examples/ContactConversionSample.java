/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datbear.fileservice.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.datbear.fileservice.*;
import net.datbear.fileservice.impl.*;

/**
 *
 * @author bitstudent
 */
public class ContactConversionSample {
    public static void main(String[] args) {
        FileReaderStrategy<String> tfr = new TextFileReader("src/contactsTest.txt");
        FileWriterStrategy<String> tfw = new TextFileWriter("src/contactsTest.txt", false);
        FormatStrategy<String, Contact> cc = new ContactsConverter();
        List<Contact> contacts = new ArrayList<Contact>();
        List<Contact> fileContacts = null;
        //create the contacts...
        Contact a = new Contact("Smith","Bob","1234 Street St.","Milwaukee","WI","53186","bob@gmail.com","222-333-4444");
        Contact b = new Contact("Jones", "Sally", "1422 Go St.", "Mukwanago", "WI", "53188", "sally@gmail.com", "333-444-5555");
        Contact c = new Contact("Smith", "Dan", "12354 ABC Lane", "Brooklyn", "NY", "53189", "dan@gmail.com", "444-555-6666");
        
        //using the ContactsConverter without the fileservice - omg flexibility
        List<String> encodedContacts = new ArrayList<String>();
        encodedContacts.add("Smalls|Biggie|126 ABC St.|Waukesha|WI|53188|biggie@gmail.com|555-666-7777");
        Contact d = ((ContactsConverter)cc).decode(encodedContacts).get(0);//
        
        //add them to the list...
        contacts.add(a);
        contacts.add(b);
        contacts.add(c);
        contacts.add(d);
        
        FileService<String, Contact> fs = new FileService<String, Contact>(tfr, tfw, cc, cc);
        try{
            if(fs.writeFile(contacts)){//if writing was successful
                fileContacts = fs.readFile();
                System.out.println("All contacts read from file:");
                for (Contact contact : fileContacts) {
                    System.out.println(contact);
                }
                
                System.out.println("\n\nSecond contact:");
                System.out.println(fileContacts.get(1));
                
                System.out.println("\n\nSecond contact's city:");
                System.out.println(fileContacts.get(1).getCity());
            }
            
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
        
        
    }
}
