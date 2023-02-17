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
            String query="create table "+table_name+"(id serial primary key, IIN float," +
                    " name varchar(20), surname varchar(20), gender boolean, age int, address varchar(20)," +
                    " insurance boolean, payment varchar(20));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createTableDoc(Connection conn,String table_name){
        Statement statement;
        try {
            String query="create table "+table_name+"(id serial primary key, name varchar(20), " +
                    "surname varchar(20), specialty varchar(20), time varchar(50));";
            statement=conn.createStatement();
            statement.executeUpdate(query);

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void createTableApp(Connection conn,String table_name){
        Statement statement;
        try {
            String query="create table "+table_name+"(id serial primary key, name varchar(20), " +
                    "surname varchar(20), specialty varchar(20), time varchar(50));";

            String createTableApp = "CREATE TABLE appointment AS " +
                    "SELECT patients.iin, t1.col2, t2.col3 " +
                    "FROM table1 t1 " +
                    "JOIN table2 t2 ON t1.id = t2.id";
            statement=conn.createStatement();
            statement.executeUpdate(query);

        }catch (Exception e){
            System.out.println(e);
        }
    }


}