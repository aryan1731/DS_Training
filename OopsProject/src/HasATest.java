
public class HasATest {

	public static void main(String[] args) {
		Human theHuman = new Human();
		theHuman.breathing();
		theHuman.thinking();
		theHuman.drinkLemonJuice();
		theHuman.doPranayama();

	}

}


class Heart {
	void pumping() {
		System.out.println("Heart is pumping....");
	}
}
class Brain{
	void analyzing() {
		System.out.println(" Brain is analyzing...");
	}
}
class Kidney{
	void filterBlood() {
		System.out.println("kidney is filtering blood...");
	}
}

class Lung{
	void oxygenateBlood() {
		System.out.println("oxygenating blood.....");
	}
}

class Human{
	private Heart myHeart = new Heart() ;
	private Brain brain = new Brain();
	private Kidney rightKidney = new Kidney();
	private Kidney leftKidney = new Kidney();
	private Lung rightLung = new Lung();
	private Lung leftLung = new Lung();
	
	void breathing() {
		System.out.println(" Human is breathing");
		myHeart.pumping();
	}
	void thinking() {
		System.out.println("Human is thinking....");
		brain.analyzing();
	}
	void drinkLemonJuice() {
		System.out.println("human is drinking lemon juice...");
		leftKidney.filterBlood();
		rightKidney.filterBlood();
	}
	void doPranayama() {
		System.out.println("Doing Pranayama....");
		rightLung.oxygenateBlood();
		leftLung.oxygenateBlood();
	}
	
}