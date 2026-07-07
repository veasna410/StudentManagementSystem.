import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManagementSystem {
    Connection conn = DBConnection.getConnection();

    public void add(String name) {
        try {
            String sql = "INSERT INTO students  (name) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Student added!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {

        try {

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student has deleted!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, String newname) {
        try {
            String sql = "UPDATE students set name =? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newname);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Student"+" "+id+" Updated!");
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void search(int id) {
        try {
            String sql = "SELECT * FROM students WHERE id =? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("Found!\n" + id + " " + name);
            } else {
                System.out.println("Not found!");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + " " + name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}