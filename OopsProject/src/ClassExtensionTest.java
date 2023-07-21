
public class ClassExtensionTest {

	public static void main(String[] args){
		
//		Doctor x = new Doctor();
//		HeartSurgeon x = new Surgeon(); //wrong.... will not accept a demotion
		Doctor x = new HeartSurgeon();
		
		
//		Doctor       x = new Surgeon();
		
		
		x.Diagnose(); //compile time binding is of Doctor::dignose()	
					//but at runtime it finds the HeartSurgon's object
					//hence runtime binding is  of HeartSurgeon::diagnose()
		x.Prescribe();
		x.Charge();
		
		
//		if(x instanceof Doctor) {
//			System.out.println("its a Doctor's object");
//		}
//		else {
//			System.out.println("its not a Doctor's object");
//		}
//		
//		System.out.println("-------------");
//		
//		if(x instanceof Surgeon) {
//			System.out.println("its a Surgeon's object");
//		}
//		else {
//			System.out.println("its not a Surgeon's object");
//		}
//		
//		System.out.println("-------------");
//		
//		if(x instanceof HeartSurgeon) {
//			System.out.println("its a HeartSurgeon's object");
//		}
//		else {
//			System.out.println("its not a HeartSurgeon's object");
//		}
	}

}

class Doctor {
	void Diagnose() {
		System.out.println("Doctor: the doctor is diagnosing... ENT checkup");
	}
	void Prescribe() {
		System.out.println("Doctor: doctor is prescribing RGB pills");
	}
	void Charge() {
		System.out.println("Doctor: the doctor is charging 300/-");
	}
	
}
class Surgeon extends Doctor{
	void Diagnose() {
		System.out.println("Surgeon: is diagnosing...CT scan/MRI scan ");
	}
	void Prescribe() {
		System.out.println("Surgeon: is prescribing.... expensive pills");
	}
	void Charge() {
		System.out.println("Surgeon: is charging..... 1000/-");
	}
	void Cut() {
		System.out.println("Surgeon: is cutting");
	}
	void Stitch() {
		System.out.println("Surgeon: is stitching");
	}
}
class HeartSurgeon extends Surgeon{
	void Diagnose() {
		System.out.println("HeartSurgeon: is diagnosing... ECG report");
	}
	void Prescribe() {
		System.out.println("HeartSurgeon: is prescribing... expensive pills,,, plus yoga.. plus excersise");
	}
	void Charge() {
		System.out.println("HeartSurgeon: is charging 3000/-");
	}
}
