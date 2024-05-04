package main_classes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import Enums.ReservationStatus;

public class CarAgency {
    private int agencyId;
    private String location;
    private String contactInformation;
    private List<Car> availableCars;
    private double totalRevenue;
    private List<Reservation> reservations;

    public CarAgency(int agencyId, String location, String contactInformation, List<Car> availableCars, double totalRevenue) {
        this.agencyId = agencyId;
        this.location = location;
        this.contactInformation = contactInformation;
        this.availableCars = availableCars;
        this.totalRevenue = totalRevenue;
    }

    // Getters
    public int getAgencyId() {
        return agencyId;
    }

    public String getLocation() {
        return location;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    // Setters
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public List<Car> searchAvailableCars(Date pickupDate, Date returnDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAvailableCars'");
    }
    private boolean isCarAvailable(Car car, Date pickupDate, Date returnDate) {
        // Check if the car is available for the given dates
        for (Reservation reservation : reservations) {
            if (reservation.getCarId() == car.getVehicleId()) {
                if (pickupDate.before(reservation.getReturnDate()) && returnDate.after(reservation.getPickupDate())) {
                    return false; // Car is already reserved for the given dates
                }
            }
        }
        return true;
    }

    public void rentCar(Customer customer, Car car, Date pickupDate, Date returnDate) {
        // Check if the car is available for the given dates
        if (!isCarAvailable(car, pickupDate, returnDate)) {
            System.out.println("Car is not available for the selected dates.");
            return;
        }
    }

    
    public void returnCar(Reservation reservation) {
        // Check if the reservation exists
        if (!reservations.contains(reservation)) {
            System.out.println("Reservation does not exist.");
            return;
        }

        // Calculate rental duration
        long rentalDurationMillis = reservation.getReturnDate().getTime() - reservation.getPickupDate().getTime();
        int rentalDurationDays = (int) (rentalDurationMillis / (1000 * 60 * 60 * 24));

        // Calculate total cost based on rental duration and car's rental rate per day
        double totalCost = calculateRentalPrice(reservation.getCar(), rentalDurationDays);

        // Update reservation status
        reservation.setStatus(ReservationStatus.COMPLETED);

        // Update car's rental status
        reservation.getCar().setRentalStatus(false);

        // Update agency's revenue
        totalRevenue += totalCost;

        System.out.println("Car returned successfully. Total cost: $" + totalCost);
    }

    private double calculateRentalPrice(Car car, int rentalDurationDays) {
        // Calculate rental price based on car's rental rate per day and duration
        return car.getRentalRatePerDay() * rentalDurationDays;
    }
}

