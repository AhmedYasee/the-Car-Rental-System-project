package main_classes;

public class EmailService {
    public static void sendEmail(String emailAddress, String subject, String message) {
        // Implementation to send an email
        System.out.println("Email sent to: " + emailAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message:\n" + message);
    }
}
