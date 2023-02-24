package bankproject;

public class Customer {

    private long nationalID;
    private String name;
    private String address;
    private String email;
    private String mobileNumber;
    private boolean isLoan = false;
    Account account;

    public Customer(long nationalID, String name, String address, String email, String mobileNumber) {
        this.nationalID = nationalID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.account = new Account();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNationalID() {
        return nationalID;
    }

    public void setNationalID(long nationalID) {
        this.nationalID = nationalID;
    }

    @Override
    public String toString() {
        return "\nCustomer :" + "\nNational ID=" + nationalID + "\nNAME=" + name + "\nADDRESS=" + address + "\nEMAIL=" + email + "\nMOBLIE_NUMBER=" + mobileNumber + "\nACCOUNT_ NUMBER=" + this.account.getAccountNumber() + "\nBALANCE=" + this.account.getBalance() ;
    }

}
