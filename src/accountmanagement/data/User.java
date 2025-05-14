package accountmanagement.data;

import java.util.stream.Collectors;

// Inheritance base class 
public class User {

    private String FullName;
    private String Email;
    private String Password;

// multiple constructor example of method overloading
// full parameter constructor
    public User(String FullName, String Email, String Password) {
        this.FullName = FullName;
        this.Email = Email;
        this.Password = simpleHash(Password);
    }

    // default constructor
    public User() {
    }
// one parameter constructor 

    public User(String Email) {
        this.Email = Email;
    }

    // I built up simple own hash method for more cryptic solution
    // it does kind of caeser cipher way.
    public static final String simpleHash(String plainPassword) {

        String hashedPassword = plainPassword.chars()
                .map(c -> (c + 100) % 62) // 62, a-z (26) + A-Z (26) + 0-9 (10)
                .mapToObj(i -> {
                    if (i < 26) {
                        return String.valueOf((char) ('a' + i)); // 'a' to 'z'
                    }
                    if (i < 52) {
                        return String.valueOf((char) ('A' + (i - 26))); // 'A' to 'Z'
                    }
                    return String.valueOf((char) ('0' + (i - 52))); // '0' to '9'
                })
                .collect(Collectors.joining());

        return hashedPassword;

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
