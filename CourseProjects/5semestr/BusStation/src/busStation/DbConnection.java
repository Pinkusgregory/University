package busStation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbConnection {
	public static Connection connectToDB() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_station?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Root1234!");
		return con;
	}
}
