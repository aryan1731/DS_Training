package DAO;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.EMICard;

class EMICardDAOImplementationTest {
	EMICardDAO emidao = new EMICardDAOImplementation();

	@Test
	void test() {
		System.out.println("Test started..");
		Assertions.assertTrue(emidao != null);
		System.out.println("Got the DAO : " + emidao);
		EMICard emicard = new EMICard(5, Date.valueOf("2023-01-03"), 5, 70000, "Titanium", 1);
		// EMICard emiobj = emidao.selectEMICard(1);
		// List<EMICard> emiobj = emidao.selectAllEMICards();
		 emidao.insertEMICard(emicard);
		// emidao.updateEMICard(emicard);
//		emidao.deleteEMICard(5);
		// System.out.println("EMI Obj : " + emiobj);
		System.out.println("Test over...");
	}

}
