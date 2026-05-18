import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Properties config = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            config.load(input);
        } catch (Exception e) {
            System.out.println("Errore letture config: " + e.getMessage());
        }

        final String URL = config.getProperty("db.url");
        final String USER = config.getProperty("db.user");
        final String PASSWORD = config.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            if (conn == null) {
                System.out.println("Connessione fallita!");
                return;
            }

            System.out.println("Connesso! " + conn.getCatalog());

            String sql = "select * from city limit 10";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String countryCode = rs.getString("CountryCode");
                    String district = rs.getString("District");
                    int population = rs.getInt("Population");

                    System.out.printf("%-4d | %-35s | %-3s | %-20s | %d%n",
                            id, name, countryCode, district, population);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
