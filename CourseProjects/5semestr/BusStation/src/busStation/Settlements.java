package busStation;

public class Settlements extends BusStation{

	private int idSettlements;
	private String country;
	private String city;
	
	public Settlements(int idSettlements, String country, String city) {
		this.idSettlements = idSettlements;
		this.country = country;
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public int getIdSettlements() {
		return idSettlements;
	}
}
