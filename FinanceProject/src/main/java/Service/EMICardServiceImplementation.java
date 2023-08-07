package Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import DAO.EMICardDAO;
import DAO.EMICardDAOImplementation;
import entities.EMICard;

public class EMICardServiceImplementation implements EMICardService {
	EMICardDAO emiDao;

	public EMICardServiceImplementation() {
		emiDao = new EMICardDAOImplementation();
	}

	@Override
	public void grantEMICardService(int customerId, String cardType) {
		EMICard card = new EMICard();
		card.setCardIssueDate(Date.valueOf(LocalDate.now()));
		card.setCustomerId(customerId);
		card.setValidityYears(2);
		card.setCardType(cardType);
		if (cardType == "Gold") {
			card.setRemainingCredit(50000);
		} else {
			card.setRemainingCredit(100000);
		}

		emiDao.insertEMICard(card);
	}

	@Override
	public void revokeEMICardService(int customerId) {
		List<EMICard> cards = emiDao.selectAllEMICards();

		for (EMICard card : cards) {
			if (card.getCustomerId() == customerId) {
				emiDao.deleteEMICard(customerId);
				break;
			}
		}
	}

	@Override
	public void updateEMICardService(EMICard emiCard) {
		List<EMICard> cards = emiDao.selectAllEMICards();

		for (EMICard card : cards) {
			if (card.getCustomerId() == emiCard.getCustomerId()) {
				emiDao.updateEMICard(emiCard);
				break;
			}
		}
	}

	@Override
	public EMICard viewEMICard(int customerId) {
		return emiDao.selectEMICard(customerId);
	}

	@Override
	public List<EMICard> viewAllEMICards() {
		return emiDao.selectAllEMICards();
	}
}
