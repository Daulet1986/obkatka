package obkatka;
public class Employee extends Person{
    private String position;
    private double salary;
    private int area;

    //Constructors
    public Employee(){
        super();
    }

    public Employee(String name, String surname, String position, double salary, int area){
        setName(name);
        setSurname(surname);
        setPosition(position);
        setSalary(salary);
        setArea(area);
    }

    //Getters
    public String getPosition(){
        return position;
    }
    public double getSalary(){
        return salary;
    }
    public int getArea(){return area;}

    //Setters
    public void setPosition(String position){
        this.position = position;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setArea(int area){this.area = area;}
}