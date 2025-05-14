
package accountmanagement.data;

// to hold who login user session and whether checking auth.
// each login places in session
public class Session {
    
    public static  User CurrentUser;
    public static  User CurrentAdmin; 

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static User getCurrentAdmin() {
        return CurrentAdmin;
    }
    
}
