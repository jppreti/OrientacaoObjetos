import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBanco {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				System.out.println(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
