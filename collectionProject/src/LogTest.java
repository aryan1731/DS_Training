import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class LogTest {

	public static void main(String[] args) {
		Log log1 = new Log("INFO",LocalDateTime.now(), "Aryan", "File uploaded");
		Log log2 = new Log("WARN",LocalDateTime.now(), "Aryan", "File uploaded");
		Log log3 = new Log("ERR",LocalDateTime.now(), "Aryan", "File uploaded");
		Log log4 = new Log("DEBUG",LocalDateTime.now(), "Aryan", "File uploaded");
		Log log5 = new Log("FATAL",LocalDateTime.now(), "Aryan", "File uploaded");
		System.out.println("the content is ready");
		
		ArrayList logList = new ArrayList();
		System.out.println("the container id ready");
		
		logList.add(log1);
		logList.add(log2);
		logList.add(log3);
		logList.add(log4);
		logList.add(log5);
		System.out.println("entire content is added to the container....");
		
		Iterator logIterator = logList.iterator();	
		System.out.println("Got the iterator now iterating the content");
		while(logIterator.hasNext()) {
			Log x = (Log) logIterator.next(); //cast it to Log, as it was added as an Object
			System.out.println("Log : "+x);
		}
	}

}

class Log{
	private String logType;
	private LocalDateTime logDate;
	private String logBy;
	private String logMessage;
	public Log(String logType, LocalDateTime logDate, String logBy, String logMessage) {
		super();
		this.logType = logType;
		this.logDate = logDate;
		this.logBy = logBy;
		this.logMessage = logMessage;
	}
	@Override
	public String toString() {
		return "Log [logType=" + logType + ", logDate=" + logDate + ", logBy=" + logBy + ", logMessage=" + logMessage
				+ "]";
	}
	
	
}

