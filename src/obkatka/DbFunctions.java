package obkatka;

import java.sql.*;

public class DbFunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn,String table_name){
        Statement statement;
        try {
            String query="create table "+table_name+"(id serial primary key, IIN varchar(20), name varchar(20), surname varchar(20), age varchar(200), address varchar(20), insurance varchar(20), payment varchar(20));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_UIN(Connection conn,String table_name,int IIN) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select *  from %s where empid= %s", table_name, IIN);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

                ResultSet resultSet = statement.executeQuery("SELECT * FROM patients");
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String address = resultSet.getString(5);
                boolean insurance = resultSet.getBoolean(6);
                float payment = resultSet.getFloat(7);
                System.out.println(name + " " + surname + " " + age + " " + address + " " + insurance + " " + payment);
            }catch(Exception e){
                System.out.println(e);
            }
        }



}