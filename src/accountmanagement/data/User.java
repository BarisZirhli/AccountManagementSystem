
package accountmanagement.data;


public class User {
    private  String FullName;
    private String Email;
    private String Password;

    public User(String FullName, String Email, String Password) {
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
