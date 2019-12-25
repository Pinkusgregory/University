package busStation;

public class Bus extends BusStation{
	
	private int licensePlate;
	private int idCarrier;
	private String model;
	private int amountOfSits;
	private String mark;
	private int registryNumber;
	
	public Bus(int licensePlate,int idCarrier, String model,int amountOfSits, String mark, int registryNumber){
		this.licensePlate = licensePlate;
		this.idCarrier = idCarrier;
		this.model = model;
		this.amountOfSits = amountOfSits;
		this.mark = mark;
		this.registryNumber = registryNumber;
	}

	public int getLicensePlate() {
		return licensePlate;
	}
	
	public int getIdCarrier() {
		return idCarrier;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getAmountOfSits() {
		return amountOfSits;
	}
	
	public String getMark() {
		return mark;
	}
	
	public int getRegistryNumber() {
		return registryNumber;
	}
}
