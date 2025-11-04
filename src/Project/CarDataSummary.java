package Project;

public class CarDataSummary {
    private int carID;
    private String brand;
    private String model;
    private int year;
    private String type;
    private String fuel;
    private String transmission;
    private String condition;
    private String color;
    private String status;
    private double price;

    public CarDataSummary(int carID, String brand, String model, int year, String type,
                          String fuel, String transmission, String condition,
                          String color, String status, double price) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fuel = fuel;
        this.transmission = transmission;
        this.condition = condition;
        this.color = color;
        this.status = status;
        this.price = price;
    }

    // ✅ Add this below your existing getters
    public void setStatus(String status) {
        this.status = status;
    }

    // Existing getters ...
    public int getCarID() { return carID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getType() { return type; }
    public String getFuel() { return fuel; }
    public String getTransmission() { return transmission; }
    public String getCondition() { return condition; }
    public String getColor() { return color; }
    public String getStatus() { return status; }
    public double getPrice() { return price; }
}