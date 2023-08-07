package DAO;

import java.util.List;

import entities.EMICard;

public interface EMICardDAO { // EMICard Repository

	EMICard selectEMICard(int customerId);

	List<EMICard> selectAllEMICards();

	void insertEMICard(EMICard emiCard);

	void updateEMICard(EMICard emiCard);

	void deleteEMICard(int customerId);
}
