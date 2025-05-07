
package accountmanagement.data;

import java.util.Date;


public class Customer extends User {
   private Date OpenAccount;

    public Customer(Date OpenAccount, String FullName, String Email, String Password) {
        super(FullName, Email, Password);
        this.OpenAccount = OpenAccount;
    }

    public Date getOpenAccount() {
        return OpenAccount;
    }

    public void setOpenAccount(Date OpenAccount) {
        this.OpenAccount = OpenAccount;
    }

    public Customer(Date OpenAccount) {
        super("test", "test","test");
        this.OpenAccount = OpenAccount;
        
    }
}
