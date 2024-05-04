package main_classes;
import java.util.Date;

import Enums.ReservationStatus;

public class Reservation {
      private int reservationId;
    private int customerId;
    private int carId;
    private Date pickupDate;
    private Date returnDate;
    private double totalCost;
    private String pickupLocation;
    private String returnLocation;
    private ReservationStatus status;
    private Customer customer;
    private Car car;

    public Reservation(int reservationId, int customerId,int carId, Date pickupDate, Date returnDate, double totalCost, String pickupLocation, String returnLocation, ReservationStatus status,Customer customer,Car car) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.carId = carId;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.status = status;
        this.customer = customer;
        this.car = car;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getCarId() {
        return carId;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setPickupDate(Date newPickupDate) {
        this.pickupDate = newPickupDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        
        return car;
    }

    public void setFeedback(String feedback) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setFeedback'");
    }

    public void setRating(int rating) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRating'");
    }
    
}
