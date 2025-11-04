package Project;

public class Car {
    private int carID;
    private String brand, model, type, fuel, transmission, condition, color, status;
    private int year;
    private double price;
    private String customerUsername = "", payment = "", address = "", email = "", phone = "", ic = "";
    private String salesmanUsername;
    
    public Car() {}

    public Car(int carID, String brand, String model, int year, String type, String fuel,
               String transmission, String condition, String color, String status, double price,
               String customerUsername, String payment, String address, String email, String phone, String ic) {
        this.carID = carID; this.brand = brand; this.model = model; this.year = year;
        this.type = type; this.fuel = fuel; this.transmission = transmission;
        this.condition = condition; this.color = color; this.status = status; this.price = price;
        this.customerUsername = customerUsername; this.payment = payment;
        this.address = address; this.email = email; this.phone = phone; this.ic = ic;
    }

    // All Getters and Setters
    public int getCarID() { return carID; } public void setCarID(int carID) { this.carID = carID; }
    public String getBrand() { return brand; } public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; } public void setModel(String model) { this.model = model; }
    public int getYear() { return year; } public void setYear(int year) { this.year = year; }
    public String getType() { return type; } public void setType(String type) { this.type = type; }
    public String getFuel() { return fuel; } public void setFuel(String fuel) { this.fuel = fuel; }
    public String getTransmission() { return transmission; } public void setTransmission(String transmission) { this.transmission = transmission; }
    public String getCondition() { return condition; } public void setCondition(String condition) { this.condition = condition; }
    public String getColor() { return color; } public void setColor(String color) { this.color = color; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public double getPrice() { return price; } public void setPrice(double price) { this.price = price; }
    public String getCustomerUsername() { return customerUsername; } public void setCustomerUsername(String customerUsername) { this.customerUsername = customerUsername; }
    public String getPayment() { return payment; } public void setPayment(String payment) { this.payment = payment; }
    public String getAddress() { return address; } public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; } public void setPhone(String phone) { this.phone = phone; }
    public String getIc() { return ic; } public void setIc(String ic) { this.ic = ic; }
     public String getSalesmanUsername() { return salesmanUsername; }
    public void setSalesmanUsername(String salesmanUsername) { this.salesmanUsername = salesmanUsername; }
}