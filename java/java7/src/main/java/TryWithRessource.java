import java.sql.*;

public class TryWithRessource {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");

        String url = "jdbc:h2:./default";
        String query = "SELECT * FROM PERSON;";

        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Personalnummer: " + rs.getInt("personalnummer"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
