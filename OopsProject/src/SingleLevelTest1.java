
public class SingleLevelTest1 {
	public static void main(String[] args) {
		/*Person personObj = new Person(24);
		personObj.showPerson();
		System.out.println("-----------------");
		*/
		
		/*Student studentObj = new Student('M',"Jack",24,   123,"Bharati Vidyapeeth","Mech Eng",899);
		studentObj.showStudent();*/
		
		
		System.out.println("-----------------");
		Employee empObj = new Employee('F',"Jane",22,   323,"MIT","IT Eng",999, 1212,"Google Inc","Brain Analyst",9999);

		empObj.showEmployee();
	}
}


class Person{
	private char gender;
	private String name;
	private int age;
	
	Person(){
		System.out.println("Person() ctor....");
	}
	
	Person(int age) {
		this('F',"NONAME",age); //invoking ctor of the same class - reuse
		/*System.out.println("START=> Person(int)");
			this.age = age;
		System.out.println("FINISH=> Person(int)");*/
		
	}
	
	Person(char gender, String name, int age){
		
		System.out.println("Person(char,string,int) ctor....");
		if(gender == 'M' || gender == 'F') {
			this.gender = gender;
		}
		else {
			RuntimeException runtimeGenderEx = new RuntimeException("Invalid gender : "+gender);
			throw runtimeGenderEx;
		}
//		if(name.matches("^[a-zA-Z]*$")) {
		
		if(Validator.checkStringWithSpace(name)) {
			this.name = name;
		}
		else {
			RuntimeException runtimeNameEx = new RuntimeException("Invalid name : "+name);
			throw runtimeNameEx;
		}
		
		if(Validator.checkNumber(age, 1, 120)) {
			this.age = age;
		}
		else {
			RuntimeException runtimeAgeEx = new RuntimeException("Invalid age : "+age);
			throw runtimeAgeEx;
		}
	}
	void showPerson() {
		
		
		System.out.println("----PERSONAL-----");
		
		System.out.println("GENDER : "+gender);
		System.out.println("NAME :  "+name);
		System.out.println("AGE : "+age);
	}
}


class Student extends Person{
	private int rollNo;
	private String collegeName;
	private int totalMarks;
	private String stream;
	Student(){
		
	}
	
	Student(char gender, String name, int age, int rollNo, String collegeName,String stream, int totalMarks){
		super(gender, name, age);

		if(Validator.checkNumber(rollNo, 1, 500)) {
			this.rollNo = rollNo;
		}
		else {
			RuntimeException runtimeRollNoEx = new RuntimeException("Invaild roll Np : " +rollNo);
			throw runtimeRollNoEx;
		}
		if(Validator.checkStringWithSpace(collegeName)) {
			this.collegeName = collegeName;
		}
		else {
			RuntimeException runtimeCollegeNameEx = new RuntimeException("Invalid collge Name : "+collegeName);
			throw runtimeCollegeNameEx;
		}
		if(Validator.checkNumber(totalMarks, 1, 1000)) {
			this.totalMarks = totalMarks;
		}
		else {
			RuntimeException runtimeMarksEx = new RuntimeException("Invalid Marks : "+totalMarks);
			throw runtimeMarksEx;
		}

		if(Validator.checkStringWithSpace(stream)){
			this.stream = stream;
		}
		else {
			RuntimeException runtimeStreamEx = new RuntimeException("Invalid Stream : "+stream);
			throw runtimeStreamEx;
		}
		
		System.out.println("Student() ctor....");
	}
	void showStudent() {
		super.showPerson(); //super. to invoke super class member/data/function
		System.out.println("---- STUDENT ----");
		System.out.println("ROLLNO : "+rollNo);
		System.out.println("COLLGE : "+collegeName);
		System.out.println("STREAM : "+stream);
		System.out.println("MARKS  : "+totalMarks);
	}
	
}


class Employee extends Student{
	
	private int empno;
	private String companyName;
	private String designation;
	float salary;
	
	Employee(char gender, String name, int age, int rollNo,String collegeName, String stream, int totalMarks,int empno, String companyName, String designation, float salary) {
//		Student(char gender, String name, int age, int rollNo, String collegeName,String stream, int totalMarks){

		super(gender,name, age, rollNo, collegeName, stream , totalMarks);
		System.out.println("Employee() ctor...");
		
		if(Validator.checkNumber(empno, 100, 2000)) {
			this.empno = empno;			
		}
		else {
			RuntimeException runtimeEmpnoEx = new RuntimeException("Invalid empno : "+empno);
			throw runtimeEmpnoEx;
		}
		
		if(Validator.checkStringWithSpace(companyName)) {
			this.companyName = companyName;
		}
		else {
			RuntimeException runtimeCompanyNameEx = new RuntimeException("Invalid companyName : "+companyName);
			throw runtimeCompanyNameEx;
		}
		
		if(Validator.checkStringWithSpace(designation)) {
			this.designation = designation;
		}
		else {
			RuntimeException runtimeDesignationEx = new RuntimeException("Invalid designation : "+designation);
			throw runtimeDesignationEx;
		}
		

		if(Validator.checkNumber(salary, 5000, 20000)) {
			this.salary = salary;			
		}
		else {
			RuntimeException runtimeSalaryEx = new RuntimeException("Invalid salary : "+salary);
			throw runtimeSalaryEx;
		}
	}
	
	void showEmployee() {
		super.showStudent(); //super. to invoke super class member/data/function
		System.out.println("---- EMPLOYEE ----");
		System.out.println("EMPNO  : "+empno);
		System.out.println("COMPANY: "+companyName);
		System.out.println("DESG   : "+designation);
		System.out.println("SALARY : "+salary);
	}
}
