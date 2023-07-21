
public class SingleLevelTest {
	public static void main(String[] args) {
//		Board board = new Board("CBSE");
//		board.getName();
		
//		Board board = new School("CBSE", "DAV");
//		board.getName();
//		
		Board board = new Student("CBSE", "KV", "ram" );
		board.getName();
	}
}

class Board{
	private String boardName ;

	public Board(String name) {
		this.boardName = name;
	}
	void getName() {
		
		System.out.println("Board Name = " +boardName);
	}
	
}

class School extends Board{
	private String schoolName;

	public School(String boardName, String schoolName) {
		super(boardName);
		this.schoolName = schoolName;
	}

	void getName() {
		super.getName();
		System.out.println("School name = "+schoolName);
	}
	
	
	
}

class Student extends School{
	private String studentName;

	public Student(String boardName, String schoolName ,String studentName) {
		super(boardName, schoolName);
		this.studentName = studentName;
	}
	
	void getName() {
		super.getName();
		System.out.println("student name =" +studentName);
	}

}
