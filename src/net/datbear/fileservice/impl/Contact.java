
package net.datbear.fileservice.impl;

/**
 * Represents a contact.
 * @author jrankin2
 *  first name, last name, street address, 
city, state, zip, email, phone fields
 */
public class Contact {
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phone;

    public Contact(String lastName, String firstName, String streetAddress, String city, String state, String zipCode, String email, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    public String toString(){
        //should probably use a stringbuilder for this, but laziness
        //prevails for now.
        String d = "|";//delimiter, d for sanity
        return lastName + d +
                firstName + d +
                streetAddress + d +
                city + d +
                state + d +
                zipCode + d +
                email + d +
                phone;
    }
}
