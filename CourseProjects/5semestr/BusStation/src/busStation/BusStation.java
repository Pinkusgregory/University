package busStation;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

public abstract class BusStation {
	private static ArrayList<Bus> bus = new ArrayList<Bus>();
	private static ArrayList<Staff> staff = new ArrayList<Staff>();
	private static ArrayList<Trips> trip = new ArrayList<Trips>();
	private static ArrayList<Settlements> settlement = new ArrayList<Settlements>();
	public static Connection con;
	public static ResultSet rs;

	public static ArrayList<Bus> getBus() {
		return bus;
	}

	public static ArrayList<Staff> getStaff() {
		return staff;
	}

	public static ArrayList<Trips> getTrip() {
		return trip;
	}
	
	public static ArrayList<Settlements> getSettlement() {
		return settlement;
	}

	public static void readDataFromDB() throws SQLException, ClassNotFoundException {
		con = DbConnection.connectToDB();
		Statement s = con.createStatement();
		rs = s.executeQuery("Select * from bus");
		// read bus data
		while (rs.next())
			bus.add(new Bus(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
		// read staff data
		rs = s.executeQuery("Select * from staff");
		while (rs.next())
			staff.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getInt(11)));
		// read trip data
		rs = s.executeQuery("Select * from trip");
		while (rs.next())
			trip.add(new Trips(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getInt(7)));
		// read settlement data
		rs = s.executeQuery("Select * from settlements");
		while (rs.next())
			settlement.add(new Settlements(rs.getInt(1), rs.getString(2), rs.getString(3)));
	}
}