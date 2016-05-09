package AddressBook;

public class Contact extends person{

    private Address address;
    private String phoneNumber;
    private String email;
    private String twitterAccount;
    private String faceBookLink;

    public Contact( String firstName, String lastName, String phoneNumber, Address address, String email, String twitterAccount, String faceBookLink)
    {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email=email;
        this.twitterAccount=twitterAccount;
        this.faceBookLink=faceBookLink;
    }

    public Contact (String firsName, String lastName, Address address )
    {
super (firsName,lastName);
        this.address= address;
    }
    @Override
    public String toString()
    {
        return super.toString()+ "Phone Number: " + phoneNumber + " " + address + "Email: " + email + "Twitter: "+ twitterAccount + " Facebook:"+ faceBookLink;
    }
}
