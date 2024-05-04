package main_classes;

public class PayPalProcessor {
    public static boolean processPayment(double amount, int customerId) {
        // Simulating PayPal payment processing
        // Here you can implement your actual PayPal payment processing logic
        System.out.println("Processing PayPal payment for amount " + amount + " for customer " + customerId);
        if (Math.random() < 0.85) { // 85% success rate
            return true;
        } else {
            return false;
        }
    }
}
