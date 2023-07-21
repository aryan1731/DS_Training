public class DataTypesTest{
	public static void main(String[] args) {
		Animal animal1 = new Animal(2,"Male", "parrot", "green");
		animal1.printAnimal();
	
//		animal1.ChangeLegs(4);
//		System.out.println("number of legs of the animal are " +animal1.GetLegs());
//		System.out.println("total number of legs" +animal1.TotalNumberOfLegs(5));
		
		animal1.run();
		animal1.run(23.4f);
		animal1.run(45);
		animal1.run(23, 300);
		
	}
}




class Animal {
	private int legs;
	private String gender;
	private String species;
	private String colour;
	
	
	
	public Animal(int legs, String gender, String species, String colour) {
		this.legs = legs;
		this.gender = gender;
		this.species = species;
		this.colour = colour;
	}
//	public void setAnimal(int legs, String gender, String species, String colour) {
//		this.legs = legs;
//		this.gender = gender;
//		this.species = species;
//		this.colour = colour;
//	}
	 public void printAnimal() { // 1st type | no arg | no return
		 System.out.println("legs    :" +legs);
		 System.out.println("gender  :" +gender);
		 System.out.println("species :" +species);
		 System.out.println("colour  :" +colour);
	 }
		
	 void changeLegs(int newLegs) { // 2nd type | with arg | no return
		 System.out.println("Changing number of legs....");
		 legs = newLegs;
	 }
	 float totalNumberOfLegs(int quantity) { // 3rd type | with arg | with return
		 System.out.println("Total number of legs...");
		 return legs*quantity;
	 }
	 int getLegs() { // 4th type | no arg  | with return
		 System.out.println("number of legs of the animal are");
		 return legs;
	 }
	 
	 void run() {
		 System.out.println("the "+this.species+" is running");
	 }
	 void run(int speed ) {
		 System.out.println("the animal is with a speed of "+speed);
	 }
	 void run(int speed, int distance) {
		 System.out.println("the animal ran "+distance+ "with the speed of" +speed);
	 }
	 void run(float speed) {
		 System.out.println("the animal is with a speed of "+speed);
	 }
	
	
}