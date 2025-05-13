package accountmanagement.data;

import java.util.Date;


//Interitance derived class
public  class Customer extends User {

    private Date OpenAccount;
    private String Address;

    public Customer(Date OpenAccount, String Address, String FullName, String Email, String Password) {
        super(FullName, Email, Password);
        this.OpenAccount = OpenAccount;
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getOpenAccount() {
        return OpenAccount;
    }

    public void setOpenAccount(Date OpenAccount) {
        this.OpenAccount = OpenAccount;
    }

  
}
