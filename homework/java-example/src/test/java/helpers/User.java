package helpers;

import static helpers.RandomHelper.*;

public class User {

    private static final String MAIN_COUNTRY = "United States";

    private String taxId;
    private String company;
    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private String country;
    private String zone;
    private String email;
    private String phone;
    private String password;

    public User setRandomData(){
        setTaxId(getNumericLineWithLength(10));
        setCompany(getLettersLineWithLength(10));
        setFirstName(getLettersLineWithLength(7));
        setLastName(getLettersLineWithLength(7));
        setAddress(getLettersLineWithLength(5)+" "+getNumericLineWithLength(3));
        setPostCode(getNumericLineWithLength(5));
        setCity(getLettersLineWithLength(10));
        setCountry(MAIN_COUNTRY);
        setEmail(getLettersLineWithLength(5)+"@"+getLettersLineWithLength(4)+"."+getLettersLineWithLength(2));
        setPhone(getNumericLineWithLength(10));
        setPassword(getLettersLineWithLength(5)+getNumericLineWithLength(5)+getLettersLineWithLength(5));
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public User setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public User setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public User setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getZone() {
        return zone;
    }

    public User setZone(String zone) {
        this.zone = zone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}

