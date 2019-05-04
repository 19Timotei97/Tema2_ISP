package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema2_ISP_CTD.Evidenta;
import Tema2_ISP_CTD.Proprietar_masina;

class TestVerificareRovinieta {

	@Test
	void testVerificareRovinieta() 
	{
		Proprietar_masina propMas1 = new Proprietar_masina("Gigel Ionel", "1860316224495", "Str Caramizilor Nr. 23");
		Evidenta evidenta = new Evidenta();
		propMas1.introducereDate("B18ECK", "ZF893FQ", evidenta);
		
		assertTrue(propMas1.verificareRovinieta("B18ECK", "ZF893FQ", evidenta));
	}

}
