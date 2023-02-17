package obkatka;

public class Appointment {
    Payment payment = new Payment(payment.getDoctor(),payment.getPrice(),payment.getInsurance());
    private Float amount = payment.getPrice();
    private String doctor = payment.getDoctor()
    private Boolean paidSuccessful = payment.processPayment(amount);
}
