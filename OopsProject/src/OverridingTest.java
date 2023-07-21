
public class OverridingTest {
	public static void main(String[] args){
		
	}
}

class GrandFather{
	void farming(){
		System.out.println(" GrandFather: farming in tradition style... using bull.. ploughing");
	}
}

class Father extends GrandFather {
	void farming() {
		System.out.println(" Father: farming in new style.... using tractor");
	}
}

class Child extends Father {
	void farming() {
		System.out.println(" Child: farming in new style.... using robotic tractor");
	}
	 void javaCoding() {
		 System.out.println("Child: the child knows java coding");
	 }
}