package busStation;

public class Trips extends BusStation {
	private int idTrip;
	private String departureTime;
	private String arrivalTime;
	private int distance;
	private String schedule;
	private String departureStation;
	private int idSettlements;

	public Trips(int idTrip, String departureTime, String arrivalTime, int distance, String schedule,
			String departureStation, int idSettlements) {
		super();
		this.arrivalTime = arrivalTime;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.distance = distance;
		this.idSettlements = idSettlements;
		this.idTrip = idTrip;
		this.schedule = schedule;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public String getDepartureStation() {
		return departureStation;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getIdSettlements() {
		return idSettlements;
	}
	
	public int getIdTrip() {
		return idTrip;
	}
	
	
	public String getSchedule() {
		return schedule;
	}

}
