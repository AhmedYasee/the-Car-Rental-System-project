package main_classes;
import java.time.LocalDate;
import java.util.Date;

import Enums.PaymentStatus;

public class Invoice {
      private int invoiceId;
    private int customerId;
    private int reservationId;
    private double totalAmount;
    private int rentalPeriod;
    private Date dateOfIssue;
    private PaymentStatus paymentStatus;

    public Invoice(int invoiceId, int customerId, int reservationId, double totalAmount, int rentalPeriod, Date dateOfIssue, PaymentStatus paymentStatus) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.reservationId = reservationId;
        this.totalAmount = totalAmount;
        this.rentalPeriod = rentalPeriod;
        this.dateOfIssue = dateOfIssue;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getInvoiceId() {
        return invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
