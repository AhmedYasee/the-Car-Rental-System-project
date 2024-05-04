package main_classes;

public class CreditCardProcessor {
    public static boolean processPayment(double amount, int customerId) {
        // Simulating credit card payment processing
        // Here you can implement your actual credit card payment processing logic
        System.out.println("Processing credit card payment for amount " + amount + " for customer " + customerId);
        if (Math.random() < 0.9) { // 90% success rate
            return true;
        } else {
            return false;
        }
    }
}
