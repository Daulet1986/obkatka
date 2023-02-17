package obkatka;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DbFunctions db = new DbFunctions();
        Connection conn=db.connect_to_db("postgres","postgres","atterol");

        db.createTable(conn,"patients");
        db.createTableDoc(conn,"doctors");

        while(true){
            System.out.println("1. List all patients");
            System.out.println("2. Update information");
            System.out.println("3. Add a patient");
            System.out.println("4. Delete a patient");
            System.out.println("5. Search");
            System.out.println("6. Quit");

            int command = scanner.nextInt();

            if(command == 1){
                Statement statement = conn.createStatement();
                String SQL_SELECT_TASKS = "select * from patients";
                ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);

                while(result.next()){
                    System.out.println(result.getInt("id") + " " +
                            result.getFloat("IIN") + " " +
                            result.getString("name") + " " +
                            result.getString("surname")  + " " +
                            result.getBoolean("gender")  + " " +
                            result.getInt("age")  + " " +
                            result.getString("address")  + " " +
                            result.getBoolean("insurance") + " " +
                            result.getString("payment"));
                }
            }
            else if(command == 2){
                String sql = "update patients set payment = 'Done' where id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Input patient id:");
                int patientId = scanner.nextInt();
                preparedStatement.setInt(1, patientId);
                preparedStatement.executeUpdate();
            }
            else if(command == 3){
                String sql = "insert into patients(IIN, name, surname, gender, age, address, insurance, payment) values(?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Add a patient: ");
                scanner.nextLine();
                System.out.println("Input patient IIN:");
                float IIN = Float.parseFloat(scanner.nextLine());
                System.out.println("Input patient name:");
                String name = scanner.nextLine();
                System.out.println("Input patient surname:");
                String surname = scanner.nextLine();
                System.out.println("Input patient gender:");
                boolean gender = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("Input patient age:");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Input patient address:");
                String address = scanner.nextLine();
                System.out.println("Input patient insurance:");
                boolean insurance = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("Input service fee:");
                String payment = scanner.nextLine();

                preparedStatement.setFloat(1, IIN);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, surname);
                preparedStatement.setBoolean(4, gender);
                preparedStatement.setInt(5, age);
                preparedStatement.setString(6, address);
                preparedStatement.setBoolean(7, insurance);
                preparedStatement.setString(8, payment);
                preparedStatement.executeUpdate();
            }

            else if(command == 4){
                String sql = "delete from patients where id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Input patient id:");
                int patientId = scanner.nextInt();
                preparedStatement.setInt(1, patientId);
                preparedStatement.executeUpdate();
            }
            else if(command == 5) {
                float iinToCheck;
                System.out.print("Enter IIN to check: ");
                if (scanner.hasNextFloat()) {
                    iinToCheck = scanner.nextFloat();
                }
                else {
                    System.out.println("Invalid IIN entered. Exiting.");
                    return;
                }
                boolean recordExists = false;
                String query = "select iin from patients where iin = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setFloat(1, iinToCheck);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    recordExists = true;
                }
                if (recordExists) {
                    System.out.println("Patient with IIN " + iinToCheck + " exists in the database.");
                }
                else {
                    System.out.println("Patient with IIN " + iinToCheck + " does not exist in the database.");
                }
            }
            else if (command == 6){
                System.exit(0);
            }

            else{
                System.err.println("Command not found");
            }
        }
    }
}