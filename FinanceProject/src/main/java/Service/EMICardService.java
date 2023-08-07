package Service;

import java.util.List;

import entities.EMICard;

public interface EMICardService {
	void grantEMICardService(int customerId, String cardType);

	void revokeEMICardService(int customerId);

	void updateEMICardService(EMICard emiCard);

	EMICard viewEMICard(int customerId);

	List<EMICard> viewAllEMICards();
}
