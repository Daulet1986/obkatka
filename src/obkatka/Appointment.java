package obkatka;

public class Appointment {
    Payment payment = new Payment();
    private Float amount = payment.getPrice();
    private Boolean paidSuccessful = payment.processPayment(amount);
}
