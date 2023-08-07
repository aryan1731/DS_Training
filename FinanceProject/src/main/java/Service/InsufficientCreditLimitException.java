package Service;

public class InsufficientCreditLimitException extends Exception {
	public InsufficientCreditLimitException(String str) {
		super(str);
	}
}