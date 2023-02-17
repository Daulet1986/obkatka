package obkatka;

public class Person{

    private int id;
    private static int id_gen = 1;
    private String name;
    private String surname;
    private int age;
    private String phone_num;

    public Person(){
        id = id_gen++;
    }

    public Person(int id, String name, String surname,int age, String phone_num){
        this.name=name;
        this.surname = surname;
        this.age = age;
        this.phone_num = phone_num;
    }

    ///Getters
    public int getID(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getNum(){
        return phone_num;
    }
    ///Setters
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setNum(String phone_num){
        this.phone_num = phone_num;
    }
}