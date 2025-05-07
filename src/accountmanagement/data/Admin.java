
package accountmanagement.data;


public class Admin extends User{
    private String Department;
    private String Location; 

    public Admin(String FullName, String Email, String Password,String Department, String Location) {
        super(FullName, Email,Password);
        this.Department = Department;
        this.Location = Location;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
