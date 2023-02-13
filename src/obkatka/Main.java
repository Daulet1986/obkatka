package obkatka;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("postgres", "postgres", "atterol");

        db.createTable(conn, "patients");

        while (true) {
            System.out.println("1. List all patients");
            System.out.println("2. Update information");
            System.out.println("3. Add a patient");
            System.out.println("4. Delete a patient");
            System.out.println("5. Quit");

            int command = scanner.nextInt();

            if (command == 1) {
                Statement statement = conn.createStatement();
                String SQL_SELECT_TASKS = "select * from patients";
                ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);

                while (result.next()) {
                    System.out.println(result.getInt("id") + " " +
                            result.getInt("IIN") + " " +
                            result.getString("name") + " " +
                            result.getString("surname") + " " +
                            result.getString("age") + " " +
                            result.getString("address") + " " +
                            result.getString("insurance") + " " +
                            result.getString("payment"));
                }
            } else if (command == 2) {
                String sql = "update patients set payment = 'Done' where id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Input patient id:");
                int patientId = scanner.nextInt();
                preparedStatement.setInt(1, patientId);
                preparedStatement.executeUpdate();
            } else if (command == 3) {
                String sql = "insert into patients(IIN, name, surname, age, address, insurance, payment) values(?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Add a patient: ");
                scanner.nextLine();
                String IIN = scanner.nextLine();
                String name = scanner.nextLine();
                String surname = scanner.nextLine();
                String age = scanner.nextLine();
                String address = scanner.nextLine();
                String insurance = scanner.nextLine();
                String payment = scanner.nextLine();

                preparedStatement.setString(1, IIN);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, surname);
                preparedStatement.setString(4, age);
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, insurance);
                preparedStatement.setString(7, payment);
                preparedStatement.executeUpdate();
            } else if (command == 4) {
                String sql = "delete from patients where id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                System.out.println("Input patient id:");
                int patientId = scanner.nextInt();
                preparedStatement.setInt(1, patientId);
                preparedStatement.executeUpdate();
            } else if (command == 5) {
                System.exit(0);
            } else {
                System.err.println("Command not found");
            }
        }
    }
}