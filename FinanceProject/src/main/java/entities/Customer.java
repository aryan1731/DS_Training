package entities;

public class Customer { // Customer Bean class.
	private int customerId;
	private String name;
	private long phoneNo;
	private String email;
	private String userName;
	private String password;
	private String address;
	private int age;
	private int salary;
	private String cardType;

	public Customer() {
	}

	public Customer(int customerId, String name, long phoneNo, String email, String userName, String password,
			String address, int age, int salary, String cardType) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.age = age;
		this.salary = salary;
		this.cardType = cardType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", address=" + address + ", age=" + age
				+ ", salary=" + salary + ", cardType=" + cardType + "]";
	}

}
