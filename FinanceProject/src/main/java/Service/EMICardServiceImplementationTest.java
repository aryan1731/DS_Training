package Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EMICardServiceImplementationTest {
	EMICardService emiservice = new EMICardServiceImplementation();

	@Test
	void test() {
		System.out.println("Test started..");
		Assertions.assertTrue(emiservice != null);
		System.out.println("Got the Service : " + emiservice);
		// EMICard emiobj = emiservice.viewEMICard(1);
		emiservice.grantEMICardService(2, "Gold");
		// emiservice.revokeEMICardService(1);
		// System.out.println("EMI Obj : " + emiobj);
		System.out.println("Test over...");
	}

}
