
public class CustomExceptionTest {
	public static void main(String[] args) 
	{
		System.out.println("MAIN started...\n");
		
		try {
			Car myCar = new Car();
			myCar.longDrive();
		}
		catch(CarKeyNotFoundException ex1) {
			System.out.println("Key Issue : "+ex1);
		} catch (LicenseNotFoundException ex2) {
			System.out.println("Key Issue : "+ex2);
		} catch (InsuranceNotFoundException ex3) {
			System.out.println("Key Issue : "+ex3);
		}
		System.out.println("\nMAIN finished...\n");
		
	}
}

class CarKeyNotFoundException extends Exception //checked exception
{
	CarKeyNotFoundException(String msg) {
		super(msg);
	}
}
class LicenseNotFoundException extends Exception //checked exception
{
	LicenseNotFoundException(String msg) {
		super(msg);
	}
}
class InsuranceNotFoundException extends Exception //checked exception
{
	InsuranceNotFoundException(String msg) {
		super(msg);
	}
}


//-------------------------------------------------------------------------------------------------


class RedSignalDishnouredException extends RuntimeException // unchecked exception
{
	RedSignalDishnouredException(String msg) {
		super(msg);
	}
}
class PunctureException extends RuntimeException // unchecked exception
{
	PunctureException(String msg) {
		super(msg);
	}
}
class FuelLowException extends RuntimeException // unchecked exception
{
	FuelLowException(String msg) {
		super(msg);
	}
}


class Car
{
	boolean keyFound=false;
	boolean licenseFound = false;
	boolean InsuranceFound = false;
	
	Car() throws CarKeyNotFoundException, LicenseNotFoundException, InsuranceNotFoundException
	{
		double value = Math.random()%10;
		
		if(value>=0.50) {
			keyFound=true;
		}
		if(value>0.6) {
			licenseFound = true;
		}
		if(value > 0.7) {
			InsuranceFound = true;
		}
		
		
		if(keyFound==true) {
			System.out.println("Car is started....");
			
		}
		else {
			//System.out.println("Car Key Not Found....");
			throw new CarKeyNotFoundException("Hey...Where is the Car Key? im not getting it...");
			
		}
		
		if(licenseFound ==true) {
			System.out.println("Car is ready....");
			
		}
		else {
			//System.out.println("Car Key Not Found....");
			throw new LicenseNotFoundException("No License found");
			
		}
		
		if(InsuranceFound ==true) {
			System.out.println("Car is ready....");
			
		}
		else {
			//System.out.println("Car Key Not Found....");
			throw new InsuranceNotFoundException("No insurance found");
			
		}
		
		
		
		
	}
	public void longDrive() {
		for (int i = 1; i <=30; i++) {
			System.out.println(i+" kms driven....");
			double value = Math.random()%10;
			if(value>0.95) {
				RedSignalDishnouredException ex1 = new RedSignalDishnouredException("Oh No!!! Red signal is dishonoured....");
				throw ex1;
			}
			else if(value>0.65 && value <=0.70) {
				PunctureException ex2 = new PunctureException("Oh No!!! tire Punctured....");
				throw ex2;
			}
			else if(value>0.05 && value < 0.1) {
				FuelLowException ex3 = new FuelLowException("oh no !!!!! Fuel Low....");
				throw ex3;
			}
		}
	}
}