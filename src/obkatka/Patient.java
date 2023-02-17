package obkatka;

public class Patient extends Person {
    private String UIN;
    private int area;
    private int insurance_amount;
    public Patient(){
        super();
    }

    public Patient(String name, String surname, int age, String UIN, String phone_num, int area, int insurance_amount){
        setName(name);
        setSurname(surname);
        setAge(age);
        setUIN(UIN);
        setArea(area);
        setInsurance(insurance_amount);
    }

    ///Getters
    public String getUIN(){
        return UIN;
    }
    public int getArea(){
        return area;
    }
    public int getInsurance(){
        return insurance_amount;
    }
    ///Setters
    public void setUIN(String UIN){
        this.UIN = UIN;
    }
    public void setArea(int area){
        this.area = area;
    }
    public void setInsurance(int insurance_amount){
        this.insurance_amount = insurance_amount;
    }

}