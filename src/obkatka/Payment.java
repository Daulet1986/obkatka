public class Payment {
    private String doctor;
    private float price;
    private boolean insurance;

    public Payment(String doctor, float price, boolean insurance) {
        this.doctor = doctor;
        this.price = price;
        this.insurance = insurance;
    }

    public float calculateTotal() {
        if (insurance) {
            return 0.0f;
        }
        return price;
    }

    public String getDoctor(){return doctor;}
    public float getPrice() {return price;}
    public boolean getInsurance(){return insurance;}

    public void setDoctor(String doctor){this.doctor = doctor;}
    public void setPrice(float price){this.price = price;}
    public void setInsurance(boolean insurance){this.insurance = insurance;}

    public boolean processPayment(float amount) {
        try {
            if (insurance == false) {
                System.out.println("Insurance was not found. Processing payment...");
                if (amount < this.price) {
                    System.out.println("Payment denied. Try again later.");
                    return false;
                } else {
                    System.out.println("Payment accepted. Your appointment will now be set.");
                    return true;
                }
            } else {
                System.out.println("Insurance is found. Your appointment will now be set.");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error occurred while processing the payment. Try again later!");
        }
    }

}
