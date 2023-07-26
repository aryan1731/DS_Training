
public class MobileTest {
	public static void main(String[] args) {
		Phone phone1 = new Phone(123);
		System.out.println("total number of phone are " +phone1.getTotalPhone());
		System.out.println("IMEI number of phone : " +phone1.getIMEIno());
		
		Phone phone2 = new Phone(13);
		System.out.println("total number of phone are " +phone2.getTotalPhone());
		System.out.println("IMEI number of phone : " +phone2.getIMEIno());
		
		Phone phone3 = new Phone(23);
		System.out.println("total number of phone are " +phone3.getTotalPhone());
		System.out.println("IMEI number of phone : " +phone3.getIMEIno());
	}
}

class Phone{
	private static int totalPhone;
	final int IMEIno;
	
	public Phone(int iMEIno) {
		super();
		IMEIno = iMEIno;
		totalPhone++;
	}

	public static int getTotalPhone() {
		return totalPhone;
	}

	public int getIMEIno() {
		return IMEIno;
	}

	public static void setTotalPhone(int totalPhone) {
		Phone.totalPhone = totalPhone;
	}
	
	
	
}

