package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.EMICard;

public class EMICardDAOImplementation implements EMICardDAO {
	Connection conn;

	public EMICardDAOImplementation() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/finance", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public EMICard selectEMICard(int customerId) {
		EMICard emiCard = null;

		try {
			Statement cst = conn.createStatement();
			ResultSet result = cst.executeQuery("select * from emiCard where customerId=" + customerId);

			if (result.next()) {
				emiCard = new EMICard();
				emiCard.setCardNo(result.getLong(1));
				emiCard.setCardIssueDate(result.getDate(2));
				emiCard.setValidityYears(result.getInt(3));
				emiCard.setRemainingCredit(result.getInt(4));
				emiCard.setCardType(result.getString(5));
				emiCard.setCustomerId(result.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emiCard;
	}

	@Override
	public List<EMICard> selectAllEMICards() {
		List<EMICard> cardList = new ArrayList<EMICard>();

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM emiCard");

			while (result.next()) {
				EMICard emiCard = new EMICard();
				emiCard.setCardNo(result.getLong(1));
				emiCard.setCardIssueDate(result.getDate(2));
				emiCard.setValidityYears(result.getInt(3));
				emiCard.setRemainingCredit(result.getInt(4));
				emiCard.setCardType(result.getString(5));
				emiCard.setCustomerId(result.getInt(6));

				cardList.add(emiCard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardList;
	}

	@Override
	public void insertEMICard(EMICard emiCard) {
		try {
			PreparedStatement pst = conn.prepareStatement(
					"insert into emiCard (cardNo,cardIssueDate,validityYears,remainingCredit,cardType,customerId) values(?,?,?,?,?,?)");
			pst.setLong(1, emiCard.getCardNo());
			pst.setDate(2, emiCard.getCardIssueDate());
			pst.setInt(3, emiCard.getValidityYears());
			pst.setInt(4, emiCard.getRemainingCredit());
			pst.setString(5, emiCard.getCardType());
			pst.setInt(6, emiCard.getCustomerId());

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateEMICard(EMICard emiCard) {
		try {
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE emiCard set cardIssueDate=?, validityYears=?, remainingCredit=?, cardType=? where customerId=?");

			pst.setDate(1, emiCard.getCardIssueDate());
			pst.setInt(2, emiCard.getValidityYears());
			pst.setInt(3, emiCard.getRemainingCredit());
			pst.setString(4, emiCard.getCardType());
			pst.setInt(5, emiCard.getCustomerId());

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteEMICard(int customerId) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM emiCard where customerId=?");

			pst.setInt(1, customerId);

			int rows = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}