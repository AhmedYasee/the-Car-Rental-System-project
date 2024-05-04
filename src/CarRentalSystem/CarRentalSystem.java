package CarRentalSystem;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enums.PaymentMethod;
import Enums.PaymentStatus;
import Enums.ReservationStatus;
import main_classes.Car;
import main_classes.CarAgency;
import main_classes.CreditCardProcessor;
import main_classes.Customer;
import main_classes.EmailService;
import main_classes.Invoice;
import main_classes.LuxuryCar;
import main_classes.PayPalProcessor;
import main_classes.Reservation;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Reservation> reservations;
    private List<Invoice> invoices;
    private List<CarAgency> agencies;

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void loginCustomer(String email, String password) {
        for (Customer customer : customers) {
            if (customer.getEmailAddress().equals(email) && customer.getPassword().equals(password)) {
                // Customer found, log them in
                System.out.println("Customer logged in successfully.");
                return;
            }
        }
        // Customer not found or incorrect credentials
        System.out.println("Invalid email or password. Please try again.");
    }
    

    public void logoutCustomer(Customer customer) {
        System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName() + " logged out successfully.");
    }
    public void addCarAgency(CarAgency agency) {
        agencies.add(agency);
    }
    public void removeCarAgency(CarAgency agency) {
        agencies.remove(agency);
    }
    public List<Car> searchAvailableCars(CarAgency agency, Date pickupDate, Date returnDate) {
        return agency.searchAvailableCars(pickupDate, returnDate);
    }
    public void rentCar(Customer customer, Car car, Date pickupDate, Date returnDate) {
        // Check if the car is available for the given dates
        if (!isCarAvailable(car, pickupDate, returnDate)) {
            System.out.println("Car is not available for the selected dates.");
            return;
        }
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
    public void returnCar(CarAgency agency, Reservation reservation) {
        agency.returnCar(reservation);
    }
    

   public List<Car> searchAvailableCars(Date pickupDate, Date returnDate, String location) {
    List<Car> availableCars = new ArrayList<>();
    
    // Logic to search for available cars based on criteria
    for (Car car : cars) {
        if (car.getLocation().equals(location)) {
            boolean available = true;
            for (Reservation reservation : reservations) {
                if (reservation.getCarId() == car.getVehicleId()) {
                    if (!reservation.getReturnDate().before(pickupDate) && !reservation.getPickupDate().after(returnDate)) {
                        available = false;
                        break;
                    }
                }
            }
            if (available) {
                availableCars.add(car);
            }
        }
    }
    
    return availableCars;
}

public void compareVehicles(Car car1, Car car2) {
    System.out.println("Comparison between " + car1.getMake() + " " + car1.getModel() + " and " + car2.getMake() + " " + car2.getModel() + ":");

    if (car1.getYearOfManufacture() != car2.getYearOfManufacture()) {
        System.out.println("Year of Manufacture:");
        System.out.println("- " + car1.getMake() + " " + car1.getModel() + ": " + car1.getYearOfManufacture());
        System.out.println("- " + car2.getMake() + " " + car2.getModel() + ": " + car2.getYearOfManufacture());
    }
    
    if (!car1.getColor().equals(car2.getColor())) {
        System.out.println("Color:");
        System.out.println("- " + car1.getMake() + " " + car1.getModel() + ": " + car1.getColor());
        System.out.println("- " + car2.getMake() + " " + car2.getModel() + ": " + car2.getColor());
    }

    // Add more comparisons as needed
}

public Reservation bookVehicle(Customer customer, Car car, Date pickupDate, Date returnDate, String pickupLocation,String returnLocation) {
    // Calculate total cost based on rental duration
    long rentalDurationInMilliseconds = returnDate.getTime() - pickupDate.getTime();
    int rentalDurationInDays = (int) (rentalDurationInMilliseconds / (1000 * 60 * 60 * 24));
    double totalCost = calculateRentalPrice(car, rentalDurationInDays);

    // Create a new reservation
    Reservation reservation = new Reservation(
        reservations.size() + 1, // Generating reservation ID
        customer.getCustomerId(),
        car.getVehicleId(),
        pickupDate,
        returnDate,
        totalCost,
        pickupLocation,
        returnLocation,
        ReservationStatus.PENDING,
        customer,
        car
    );
    

    // Add the reservation to the list of reservations
    reservations.add(reservation);

    return reservation;
}

  



    public void modifyReservation(Reservation reservation, Date newPickupDate, Date newReturnDate) {
        // Implementation to modify an existing reservation
        reservation.setPickupDate(newPickupDate);
        reservation.setReturnDate(newReturnDate);
    }

    public void cancelReservation(Reservation reservation) {
        // Implementation to cancel an existing reservation
        reservation.setStatus(ReservationStatus.CANCELLED);
    }

    public double calculateRentalPrice(Car car, int rentalDuration) {
        // Implementation to calculate the rental price based on factors
        return car.getRentalRatePerDay() * rentalDuration;
    }

    public void schedulePickupAndReturn(Reservation reservation, String pickupLocation, String returnLocation) {
        // Implementation to schedule vehicle pickup and return locations
        reservation.setPickupLocation(pickupLocation);
        reservation.setReturnLocation(returnLocation);
    }

    public void sendConfirmationEmail(Reservation reservation) {
        // Implementation to send a confirmation email after successful booking
        String message = "Dear " + reservation.getCustomerId() + ",\n\n"
                + "Your booking has been confirmed. Details:\n"
                + "Reservation ID: " + reservation.getReservationId() + "\n"
                + "Pickup Date: " + reservation.getPickupDate() + "\n"
                + "Return Date: " + reservation.getReturnDate() + "\n"
                + "Pickup Location: " + reservation.getPickupLocation() + "\n"
                + "Return Location: " + reservation.getReturnLocation() + "\n"
                + "Total Cost: " + reservation.getTotalCost() + "\n\n"
                + "Thank you for choosing our car rental service.";
    
        // Send the email
        EmailService.sendEmail(reservation.getCustomer().getEmailAddress(), "Booking Confirmation", message);
        
    }
    

    public void processPayment(Invoice invoice, PaymentMethod paymentMethod) {
    // Implementation to process payment for a rental
    double totalAmount = invoice.getTotalAmount();
    int customerId = invoice.getCustomerId();

    // Check the payment method
    if (paymentMethod == PaymentMethod.CREDIT_CARD) {
        boolean paymentSuccess = CreditCardProcessor.processPayment(totalAmount, customerId);
        if (paymentSuccess) {
            System.out.println("Payment processed successfully with credit card.");
        } else {
            System.out.println("Payment failed with credit card.");
        }
    } else if (paymentMethod == PaymentMethod.PAYPAL) {
        boolean paymentSuccess = PayPalProcessor.processPayment(totalAmount, customerId);
        if (paymentSuccess) {
            System.out.println("Payment processed successfully with PayPal.");
        } else {
            System.out.println("Payment failed with PayPal.");
        }
    } else {
        System.out.println("Invalid payment method.");
    }
}

    

public void applyLateReturnFee(Reservation reservation, int daysLate) {
    // Get the late return fee per day from the car's rental rate per day
    double lateReturnFeePerDay = reservation.getCar().getRentalRatePerDay() * 0.1; // Assuming a late fee of 10% of daily rental rate
    
    // Calculate the late return fee
    double lateReturnFee = daysLate * lateReturnFeePerDay;
    
    // Update the total cost of the reservation
    double totalCost = reservation.getTotalCost();
    totalCost += lateReturnFee;
    reservation.setTotalCost(totalCost);
}

public List<Car> viewAvailableCars(Date pickupDate, Date returnDate) {
    List<Car> availableCars = new ArrayList<>();

    for (Car car : cars) {
        boolean available = true;

        // Check if the car is already booked for the specified duration
        for (Reservation reservation : reservations) {
            if (reservation.getCarId() == car.getVehicleId()) {
                if (!(pickupDate.after(reservation.getReturnDate()) || returnDate.before(reservation.getPickupDate()))) {
                    // Car is not available for the specified duration
                    available = false;
                    break;
                }
            }
        }

        if (available) {
            availableCars.add(car);
        }
    }

    return availableCars;
}

public double calculateRentalPrice(Car car, int rentalDuration, List<String> additionalServices) {
    double basePrice = car.getRentalRatePerDay() * rentalDuration;

    // Adjust the base price based on the vehicle type
    if (car instanceof LuxuryCar) {
        basePrice *= 1.2; // Apply a 20% surcharge for luxury cars
    }

    // Calculate the price of additional services
    double additionalServicesPrice = 0;
    for (String service : additionalServices) {
        if (service.equals("GPS")) {
            additionalServicesPrice += 10; // Assume $10 per day for GPS
        } else if (service.equals("Child Seat")) {
            additionalServicesPrice += 5; // Assume $5 per day for a child seat
        }
        // Add more services and their prices as needed
    }

    // Add the additional services price to the base price
    double totalCost = basePrice + additionalServicesPrice;

    return totalCost;
}

public void sendNewOfferNotifications() {
    // Implementation to send notifications about new offers
    for (Customer customer : customers) {
        // Simulate sending a notification to each customer
        System.out.println("Sending new offer notification to " + customer.getEmailAddress());
        System.out.println("Dear " + customer.getFirstName() + ",\n");
        System.out.println("Check out our latest offers! Visit our website for more details.\n");
    }
}
public void submitFeedbackAndRating(Reservation reservation, String feedback, int rating) {
    // Implementation to allow customers to provide feedback and ratings
    reservation.setFeedback(feedback);
    reservation.setRating(rating);

    // Optionally, you can store the feedback and rating in a database or perform other actions
    System.out.println("Feedback and rating submitted for reservation ID: " + reservation.getReservationId());
}

  public void generateInvoice(Reservation reservation) {
        // Get reservation details
        int reservationId = reservation.getReservationId();
        int customerId = reservation.getCustomerId();
        int carId = reservation.getCarId();
        double totalAmount = reservation.getTotalCost();
        int rentalPeriod = calculateRentalPeriod(reservation.getPickupDate(), reservation.getReturnDate());
        Date dateOfIssue = new Date(); // Current date

        // Create invoice
        Invoice invoice = new Invoice(invoices.size() + 1, customerId, reservationId, totalAmount, rentalPeriod, dateOfIssue, PaymentStatus.PENDING);

        // Add invoice to the list
        invoices.add(invoice);

        // Print confirmation
        System.out.println("Invoice generated successfully:");
        System.out.println(invoice);
    }

   private int calculateRentalPeriod(Date pickupDate, Date returnDate) {
        // Convert Date objects to LocalDate objects
        LocalDate pickupLocalDate = pickupDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate returnLocalDate = returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate rental period in days
        return (int) ChronoUnit.DAYS.between(pickupLocalDate, returnLocalDate);
    }


}

