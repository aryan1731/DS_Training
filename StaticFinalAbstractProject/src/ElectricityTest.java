interface Electricity {
    void provide();
}
//----------------------------------------------------------------------
abstract class Power implements Electricity {
    abstract public void powerUp();
}
abstract class Internet implements Electricity {
    abstract public void browse();
}
//-------------------------------------------------------------------
abstract class App extends Internet {
	abstract void use();
}

abstract class Website extends Internet {
    abstract void cookies();
}


abstract class Appliances extends Power {
    abstract void operate();
}

abstract class Charging extends Power {
    abstract void charge();
}
//=-------------------------------------------------------
class Fan extends Appliances {

	@Override
	public void provide() {
		System.out.println("electricity is provided too fan");
		
	}

	@Override
	void operate() {
		System.out.println("fan is operating");
		
	}

	@Override
	public void powerUp() {
		System.out.println(" the fan is provided power though electricity");
		
	}
	public void blowingAir() {
		System.out.println(" the fan is blowing air");
	}
}
class AC extends Appliances {

	@Override
	public void provide() {
		System.out.println("electricity is provided to AC");
		
	}

	@Override
	void operate() {
		System.out.println("AC is operating");
		
	}

	@Override
	public void powerUp() {
		System.out.println(" AC is provided power though electricity");
		
	}
	public void cooling() {
		System.out.println("AC is cooling the room");
	}
}



class Mobile extends Charging {

	@Override
	public void provide() {
		System.out.println("electricity is provided to AC");
		
	}

	@Override
	void charge() {
		System.out.println("the mobile is charging");
		
	}

	@Override
	public void powerUp() {
		System.out.println(" Mobile is provided power though electricity");
		
	}
	public void percent() {
		System.out.println("the battery percentage is" +(100*(Math.random()%10)));
	}
}

class Car extends Charging {

	@Override
	public void provide() {
		System.out.println("electricity is provided to Car");
		
	}

	@Override
	void charge() {
		System.out.println("the Car is charging");
		
	}

	@Override
	public void powerUp() {
		System.out.println(" Car is provided power though electricity");
		
	}
	
	public void range() {
		System.out.println("the range of the car is" +(1000*(Math.random()%10)));
	}
	
}

class Insta extends App {

	@Override
	public void provide() {
		System.out.println("the electricity is provided to insta");
		
	}

	@Override
	public void use() {
		System.out.println("using insta");
		
	}

	@Override
	public void browse() {
		System.out.println("browsing insta");
		
	}
	public void reel() {
		System.out.println("insta is showing reels");
	}
	
}

class Snapchat extends App {

	@Override
	public void provide() {
		System.out.println("the electricity is provided to Snapchat");
		
	}

	@Override
	public void use() {
		System.out.println("using Snapchat");
		
	}

	@Override
	public void browse() {
		System.out.println("browsing Snapchat");
		
	}
	public void snap() {
		System.out.println("receiving snaps ");
	}
	
}
class Facebook extends Website {

	@Override
	public void provide() {
		System.out.println("the electricity is provided to Facebook");
		
	}

	@Override
	public void cookies() {
		System.out.println("facebook is asking for cookie permission");
		
	}

	@Override
	public void browse() {
		System.out.println("browsing Facebook");
		
	}
	public void FriendReq() {
		System.out.println("receiving friend requests ");
	}
	
}

class Google extends Website {

	@Override
	public void provide() {
		System.out.println("the electricity is provided to Google");
		
	}

	@Override
	public void cookies() {
		System.out.println("Google is asking for cookie permission");
		
	}

	@Override
	public void browse() {
		System.out.println("browsing using Goolge");
		
	}
	public void ads() {
		System.out.println("receiving ads related to my searches ");
	}
	
}

public class ElectricityTest {
    public static void main(String[] args) {
        // Testing Appliances
        Fan fan = new Fan();
        fan.provide();
        fan.powerUp();
        fan.operate();
        fan.blowingAir();

        AC ac = new AC();
        ac.provide();
        ac.powerUp();
        ac.operate();
        ac.cooling();

        // Testing Charging Devices
        Mobile mobile = new Mobile();
        mobile.provide();
        mobile.powerUp();
        mobile.charge();
        mobile.percent();

        Car electricCar = new Car();
        electricCar.provide();
        electricCar.powerUp();
        electricCar.charge();
        electricCar.range();

        // Testing Internet Applications
        Insta insta = new Insta();
        insta.provide();
        insta.use();
        insta.browse();
        insta.reel();

        Snapchat snapchat = new Snapchat();
        snapchat.provide();
        snapchat.use();
        snapchat.browse();
        snapchat.snap();

        // Testing Websites
        Facebook facebook = new Facebook();
        facebook.provide();
        facebook.browse();
        facebook.cookies();
        facebook.FriendReq();

        Google google = new Google();
        google.provide();
        google.browse();
        google.cookies();
        google.ads();
    }
}