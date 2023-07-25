
public class KiteTest {
	public static void main(String[] args) {
		Kite.showKiteCount();
		
		Kite kite1 = new Kite("aryan","red",40);
		kite1.showKite();
		
		Kite kite2 = new Kite("ram","blue",50);
		kite2.showKite();
		
		Kite kite3 = new Kite("shub","yellow",60);
		kite3.showKite();
		
		Kite kite4 = new Kite("sham","pink",70);
		kite4.showKite();
		
		
		kite1.kiteFight(kite4);
		
		Kite.showKiteCount();
	}
}


class Kite{
	private String owner;
	private String color;
	private int length;
	private boolean flying;
	private static int kiteCount; //shared dara across kites objects
	public static void showKiteCount() {
		System.out.println("Total kites in the sky : "+kiteCount);
	}

	public Kite(String owner, String color, int length) {
		super();
		this.owner = owner;
		this.color = color;
		this.length = length;
		this.flying = true;
		kiteCount++;
		
	}
	
	void showKite(){
		System.out.println(" kite owner : "+this.owner);
		System.out.println(" kite color : "+this.color);
		System.out.println(" kite length: "+this.length );
		System.out.println(" kite count :" +Kite.kiteCount );
		System.out.println("-------------------");
	}

	void kiteFight(Kite ref) {
		System.out.println(color+" Kite initiated a fight with " +ref.color+" kite");{
			for(int i=1;i<=20;i++) {
				
				double value = Math.random()%10;
				
				System.out.println("the kites are fighting" +i);
				
				if(value > 0.85) {
					kiteCount--;
					this.flying = false;
					System.out.println(owner +" lost the kite");
					break;
				}
				if(value<0.10) {
					kiteCount--;
					ref.flying=false;
					System.out.println(ref.owner +" lost the kite");
					kiteCount--;
				}
				if(value>=0.30 && value<= 0.4) {
					kiteCount--;
					kiteCount--;
					ref.flying = false;
					this.flying = false;
					System.out.println("both "+owner +" "+ref.owner+ "lost the kite fight");
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Kite [owner=" + owner + ", color=" + color + ", length=" + length + ", flying=" + flying + "]";
	}
	

	
	
}