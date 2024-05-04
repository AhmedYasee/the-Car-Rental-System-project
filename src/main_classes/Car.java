package main_classes;
import java.util.List;

public class Car {
    private int vehicleId;
    private String make;
    private String model;
    private String color;
    private int yearOfManufacture;
    private List<String> features;
    private double fuelLevel;
    private boolean rentalStatus;
    private double rentalRatePerDay;
    public Car(int vehicleId, String make, String model, String color, int yearOfManufacture, List<String> features, double fuelLevel, boolean rentalStatus, double rentalRatePerDay) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.features = features;
        this.fuelLevel = fuelLevel;
        this.rentalStatus = rentalStatus;
        this.rentalRatePerDay = rentalRatePerDay;
    }

    // Getters
    public int getVehicleId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public List<String> getFeatures() {
        return features;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public boolean isRentalStatus() {
        return rentalStatus;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    // Setters
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void setRentalRatePerDay(double rentalRatePerDay) {
        this.rentalRatePerDay = rentalRatePerDay;
    }

    public Object getLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLocation'");
    }

 
}
