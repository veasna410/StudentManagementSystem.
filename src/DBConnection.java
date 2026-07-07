import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "4102008"
            );

            System.out.println("Connected to MySQL!");

        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

        return conn;
    }
}
