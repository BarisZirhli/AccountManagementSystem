
package accountmanagement.data;

// to hold who login user session and whether checking auth.
public class Session {
    
    public static  User CurrentUser;
    public static  Admin CurrentAdmin; 

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static Admin getCurrentAdmin() {
        return CurrentAdmin;
    }
    
}
