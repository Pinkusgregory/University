package busStation;

public class Staff extends BusStation {
	private int idStaff;
	private String surname;
	private String name;
	private String patronymic;
	private String city;
	private int street;
	private int houseNumber;
	private int apartment;
	private String post;
	private int phone;
	private int expirience;

	public Staff(int idStaff, String surame, String name, String patronymic, String city, int street, int houseNumber,
			int apartment, String post, int phone, int expirience) {
		this.idStaff = idStaff;
		this.surname = surame;
		this.name = name;
		this.patronymic = patronymic;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartment = apartment;
		this.post = post;
		this.phone = phone;
		this.expirience = expirience;
	}

	public int getApartment() {
		return apartment;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getExpirience() {
		return expirience;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public int getIdStaff() {
		return idStaff;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public String getPost() {
		return post;
	}
	
	public int getStreet() {
		return street;
	}
	
	public String getSurname() {
		return surname;
	}
	
}
