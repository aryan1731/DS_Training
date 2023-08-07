package entities;

import java.sql.Date;

public class EMICard {
	private long cardNo;
	private Date cardIssueDate;
	private int validityYears;
	private int remainingCredit;
	private String cardType;
	private int customerId;

	public EMICard(long cardNo, Date cardIssueDate, int validityYears, int remainingCredit, String cardType,
			int customerId) {
		super();
		this.cardNo = cardNo;
		this.cardIssueDate = cardIssueDate;
		this.validityYears = validityYears;
		this.remainingCredit = remainingCredit;
		this.cardType = cardType;
		this.customerId = customerId;
	}

	public EMICard() {
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public int getValidityYears() {
		return validityYears;
	}

	public void setValidityYears(int validityYears) {
		this.validityYears = validityYears;
	}

	public int getRemainingCredit() {
		return remainingCredit;
	}

	public void setRemainingCredit(int remainingCredit) {
		this.remainingCredit = remainingCredit;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "EMICard [cardNo=" + cardNo + ", cardIssueDate=" + cardIssueDate + ", validityYears=" + validityYears
				+ ", remainingCredit=" + remainingCredit + ", cardType=" + cardType + ", customerId=" + customerId
				+ "]";
	}

}
