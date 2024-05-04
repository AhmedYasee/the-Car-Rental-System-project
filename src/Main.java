

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import Enums.ReservationStatus;
import main_classes.Car;
import main_classes.CarAgency;
import main_classes.Customer;
import main_classes.Reservation;

public class Main {
    public static void main(String[] args) {
        // Create some sample data for available cars
        List<Car> availableCars = new ArrayList<>();
        availableCars.add(new Car(1, "Make 1", "Model 1", "Color 1", 2020, new ArrayList<>(), 50.0, false, 100.0));
        availableCars.add(new Car(2, "Make 2", "Model 2", "Color 2", 2021, new ArrayList<>(), 60.0, false, 120.0));

        // Create the CarAgency object
        CarAgency agency = new CarAgency(1, "Location 1", "Contact 1", availableCars, 0.0);

        // Test searchAvailableCars method
        List<Car> searchResult = agency.searchAvailableCars(new java.util.Date(), new java.util.Date());
        System.out.println("Available cars:");
        for (Car car : searchResult) {
            System.out.println(car);
        }

        List<Reservation> reservationHistory = new ArrayList<>();
        Customer customer = new Customer(1, "John", "Doe", "john@example.com", "DL12345", reservationHistory, 0);
        agency.rentCar(customer, availableCars.get(0), new Date(), new Date());

        // Test returnCar method
        // Create a sample reservation
        Reservation reservation = new Reservation(1, customer.getCustomerId(), availableCars.get(0).getVehicleId(),
                new Date(), new Date(), 100.0, "Location 1", "Location 2", ReservationStatus.PENDING, customer, availableCars.get(0));
        agency.returnCar(reservation);
    }
}
