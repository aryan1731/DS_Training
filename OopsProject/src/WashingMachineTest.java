//import java.util.Iterator;

public class WashingMachineTest {
	public static void main(String[] args) {
		Cloth[] clothes = new Cloth[12];
		clothes[0] = new Cloth("cotton", "red", 12.5f, "front Load", false);
		clothes[0] = new Cloth("cotton","red",12.5f,"front Load",false);
		clothes[1] = new Cloth("silk","blue",10f,"top Load",false);
		clothes[2] = new Cloth("cotton","red",2.5f,"front Load",false);
		clothes[3] = new Cloth("cotton","red",12.5f,"front Load",false);
		clothes[4] = new Cloth("silk","blue",10f,"top Load",false);
		clothes[5] = new Cloth("cotton","red",2.5f,"front Load",false);
		clothes[6] = new Cloth("cotton","red",12.5f,"front Load",false);
		clothes[7] = new Cloth("silk","blue",10f,"top Load",false);
		clothes[8] = new Cloth("cotton","red",2.5f,"front Load",false);
		clothes[9] = new Cloth("cotton","red",12.5f,"front Load",false);
		clothes[10] = new Cloth("silk","blue",10f,"top Load",false);
		clothes[11] = new Cloth("cotton","red",2.5f,"front Load",false);
		WashingPowder washPowder = new WashingPowder(100, "Nirma", "Front Load", true, 10.0f);
		
		Water water = new Water("soft", 10, "30");
		
		Electricity elect = new Electricity("DC", 220f, 10, 20, "Adani");
		
		WashingMachine washingMachine1 = new WashingMachine("Godrej", washPowder, water, elect, clothes);
		WashingMachine washingMachine2 = new WashingMachine("Samsung", washPowder, water, elect, clothes);
		WashingMachine washingMachine3 = new WashingMachine("LG", washPowder, water, elect, clothes);
		
		washingMachine1.start();
		washingMachine2.start();
		washingMachine3.start();
		
		try {
			washingMachine1.join();
			washingMachine2.join();
			washingMachine3.join();
		} catch (InterruptedException e) { //1
			e.printStackTrace()	;
		}
		
		Laundry laundry1 = washingMachine1.getLaundry();
		Laundry laundry2 = washingMachine2.getLaundry();
		Laundry laundry3 = washingMachine3.getLaundry();
		
		System.out.println("Laundry from Godrej: " + laundry1);
		System.out.println("Laundry from Samsung: " + laundry2);
		System.out.println("Laundry from LG: " + laundry3);
	}
}
//class RedSignalDishnouredException extends RuntimeException // unchecked exception
//{
// RedSignalDishnouredException(String msg) {
// super(msg);
// }
//}
class noWaterException extends RuntimeException{
	noWaterException(String msg){
		super(msg);
	}
}
class breakdownException extends RuntimeException{
	breakdownException(String msg){
			super(msg);
	}
}
class DCPowerException extends RuntimeException{
	DCPowerException(String msg){
			super(msg);
	}
}
class noPowerException extends RuntimeException{
	noPowerException(String msg){
		super(msg);
	}
}

class WashingMachine extends Thread {
	private String company;
	private WashingPowder washPowder;
	private Water water;
	private Electricity elect;
	private Cloth[] clothes;
	private Laundry laundry;
	
	public WashingMachine(String company, WashingPowder washPowder, Water water, Electricity elect, Cloth[] clothes) {
		this.company = company;
		this.washPowder = washPowder;
		this.water = water;
		this.elect = elect;
		this.clothes = clothes;
	}
	
	@Override
	public void run() {
		System.out.println("Washing machine by " + company + " started!");
		laundry = washClothes();
		System.out.println("Washing machine by " + company + " finished!");
	}
	
	private Laundry washClothes() {
		Laundry laundry = new Laundry(clothes.length, 30f,
		washPowder.getPrice() * washPowder.getQuantity() + elect.getUnitUsed() * elect.getCostPerUnit(),
		water.getQuantity(), elect.getUnitUsed(), washPowder.getPrice() * washPowder.getQuantity());
		
		double value = Math.random()%10;
		
		if(water.getQuantity() ==0) { //2
			throw new noWaterException("the water ran out");
		}
		
		else if(elect.getType()=="AC") { //3
			throw new DCPowerException("no DC supply provided");
		}
		
		else if(value > 0.95) {//4
			throw new breakdownException("the washing machine broke down"+value);
		}
		else if(value< 0.1) {//5
			throw new noPowerException("the electricity was shut down"+value);
		}
		for (int i = 0; i < clothes.length; i++) {
			clothes[i].setClean(true);
			System.out.println("Cloth no. " + i + " is being washed in " + company);
		}
		return laundry;
	}
	
	public Laundry getLaundry() {
		return laundry;
	}
}

class Laundry {
	private int numberOfCloths; //cloth.length
	private float timeRequired;
	private float totalCost ;// cloth.length * price per cloth
	private float waterUsed;
	private float electricityUsed;
	private float costOfWashingPowder; //
	
	
	public Laundry(int numberOfCloths, float timeRequired, float totalCost, float waterUsed, float electricityUsed,
	float costOfWashingPowder) {
		super();
		this.numberOfCloths = numberOfCloths;
		this.timeRequired = timeRequired;
		this.totalCost = totalCost;
		this.waterUsed = waterUsed;
		this.electricityUsed = electricityUsed;
		this.costOfWashingPowder = costOfWashingPowder;
}

@Override
	public String toString() {
		return "Laundry [numberOfCloths=" + numberOfCloths + ", timeRequired=" + timeRequired + ", totalCost="
		+ totalCost + ", waterUsed=" + waterUsed + ", electricityUsed=" + electricityUsed
		+ ", costOfWashingPowder=" + costOfWashingPowder + "]";
	}
	
	public int getNumberOfCloths() {
		return numberOfCloths;
	}
	
	public void setNumberOfCloths(int numberOfCloths) {
		this.numberOfCloths = numberOfCloths;
	}
	
	public float getTimeRequired() {
		return timeRequired;
	}
	
	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}
	
	public float getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	public float getWaterUsed() {
		return waterUsed;
	}
	
	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}
	
	public float getElectricityUsed() {
		return electricityUsed;
	}
	
	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}
	
	public float getCostOfWashingPowder() {
		return costOfWashingPowder;
	}
	
	public void setCostOfWashingPowder(float costOfWashingPowder) {
		this.costOfWashingPowder = costOfWashingPowder;
	}
}

//class Tub {
// 
//}
//
//class WashingTub extends Tub {
// private int capacity;
// private String type; //
// public WashingTub(int capacity, String type) {
// super();
// this.capacity = capacity;
// this.type = type;
// }
// @Override
// public String toString() {
// return "WashingTub [capacity=" + capacity + ", type=" + type + "]";
// }
// public int getCapacity() {
// return capacity;
// }
// public void setCapacity(int capacity) {
// this.capacity = capacity;
// }
// public String getType() {
// return type;
// }
// public void setType(String type) {
// this.type = type;
// }
// 
//}

class Powder {
}

class WashingPowder extends Powder { // isA

	private int quantity;
	private String brand;
	private String type;
	private boolean scented;
	private float price;
	
	
	public WashingPowder(int quantity, String brand, String type, boolean scented, float price) {
		super();
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;// loading type
		this.scented = scented;
		this.price = price;
	}
	@Override
	public String toString() {
		return "WashingPowder [quantity=" + quantity + ", brand=" + brand + ", type=" + type + ", scented=" + scented
		+ ", price=" + price + "]";
	}
/*public String toString() {
String str = (scented) ? "Scented" :"Not Scented";
return str+ " "+brand+" Washing Powder of "+type+ " type quantity used "+quantity+ " grams ";
}*/

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isScented() {
		return scented;
	}

	public void setScented(boolean scented) {
		this.scented = scented;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

class Water {
	private String type;
	private int quantity;
	private String temperature;
	
	public Water(String type, int quantity, String temperature) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Water [type=" + type + ", quantity=" + quantity + ", temperature=" + temperature + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}

class Electricity {
	private String type; //ac dc
	private float voltage; 
	private int costPerUnit;
	private int unitUsed;
	private String supplier;
	public Electricity(String type, float voltage, int costPerUnit, int unitUsed, String supplier) {
		super();
		this.type = type;
		this.voltage = voltage;
		this.costPerUnit = costPerUnit;
		this.unitUsed = unitUsed;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", voltage=" + voltage + ", costPerUnit=" + costPerUnit + ", unitUsed="
				+ unitUsed + ", supplier=" + supplier + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public int getUnitUsed() {
		return unitUsed;
	}
	public void setUnitUsed(int unitUsed) {
		this.unitUsed = unitUsed;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
}

class Cloth {
	private String material; //
	private String color;
	private float cost;
	private String type;
	private boolean clean; //
	
	public Cloth(String material, String color, float cost, String type, boolean clean) {
		super();
		this.material = material;
		this.color = color;
		this.cost = cost;
		this.type = type;
		this.clean = clean;
	}
	@Override
	public String toString() {
		return "Cloth [material=" + material + ", color=" + color + ", cost=" + cost + ", type=" + type + ", clean="
				+ clean + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	

	
}
