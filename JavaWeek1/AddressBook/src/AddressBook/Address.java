package AddressBook;

public class Address {

    private String street;
    private String city;
    private String country;
    private String postcode;

    public Address() {
    }

    public Address(String street, String city, String country, String postcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postcode = postcode;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city){
        this.city = city;

    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcocde) {
        this.postcode = postcode;
    }


    @Override
     public String toString() {
        return String.format(
                "Street Address: %s, City: %s, Country; %s, Postcode: %s", street, city, country, postcode);
    }


}

