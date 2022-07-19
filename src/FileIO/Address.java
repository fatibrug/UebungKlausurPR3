package FileIO;

public class Address {

    private String firstname;
    private String lastname;
    private String mobilNumber;
    private String email;

    public Address(String firstname, String lastname, String mobilNumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilNumber = mobilNumber;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilNumber() {
        return mobilNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMobilNumber(String mobilNumber) {
        this.mobilNumber = mobilNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobilNumber='" + mobilNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
