package Project;

public class User {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String ic;
    private String username;
    private String password;
    private String status; // Example: "Pending", "Approved"

    // Default constructor
    public User() {
        // Empty constructor for flexibility
    }

    // Constructor with parameters
    public User(String name, String email, String phone, String gender, String ic,
                String username, String password, String status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.ic = ic;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getIc() { return ic; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getStatus() { return status; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setGender(String gender) { this.gender = gender; }
    public void setIc(String ic) { this.ic = ic; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setStatus(String status) { this.status = status; }

    // Override toString method
    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
               ", gender='" + gender + '\'' +
               ", ic='" + ic + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}
