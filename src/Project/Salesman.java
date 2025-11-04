
package Project;

public class Salesman {
    private String name;
    private String email;
    private String phone;
    private String ic;
    private String gender;
    private String username;
    private String password;

    public Salesman(String name, String email, String phone, String ic, String gender, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.ic = ic;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    // Getters and setters for each field
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getIc() { return ic; }
    public void setIc(String ic) { this.ic = ic; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
