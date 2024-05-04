package main_classes;
import java.util.List;


public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String driversLicenseNumber;
    private List<Reservation> reservationHistory;
    private int totalRentalsMade;

    public Customer(int customerId, String firstName, String lastName, String emailAddress, String driversLicenseNumber, List<Reservation> reservationHistory, int totalRentalsMade) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.driversLicenseNumber = driversLicenseNumber;
        this.reservationHistory = reservationHistory;
        this.totalRentalsMade = totalRentalsMade;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public List<Reservation> getReservationHistory() {
        return reservationHistory;
    }

    public int getTotalRentalsMade() {
        return totalRentalsMade;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public void setReservationHistory(List<Reservation> reservationHistory) {
        this.reservationHistory = reservationHistory;
    }

    public void setTotalRentalsMade(int totalRentalsMade) {
        this.totalRentalsMade = totalRentalsMade;
    }

    public Object getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
}
