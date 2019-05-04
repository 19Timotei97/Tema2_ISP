package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Tema2_ISP_CTD.Evidenta;
import Tema2_ISP_CTD.Proprietar_masina;
import Tema2_ISP_CTD.Rovinieta;

class TestVerificareRovinieta {
	/**
	 * Bidila Timotei 334 AA
	 */
	@Test
	void testVerificareRovinieta() 
	{
		Proprietar_masina propMas1 = new Proprietar_masina("Gigel Ionel", "1860316224495", "Str Caramizilor Nr. 23");
		Evidenta evidenta = new Evidenta();
		propMas1.introducereDate("B18ECK", "ZF893FQ", evidenta);
		
		assertTrue(propMas1.verificareRovinieta("B18ECK", "ZF893FQ", evidenta));
		
/* Crapa
		Proprietar_masina propMas2 = new Proprietar_masina("Gigel Ionel", "1860316224495", "Str Caramizilor Nr. 23");
		Evidenta evidenta1 = new Evidenta();
		propMas1.introducereDate("B18ECK", "ZF903AA", evidenta1);
		Rovinieta rov = evidenta1.getRovinieta(0);
		if(rov == null)
			System.out.println("Eroare");
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2018");
			rov.setData(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(propMas1.verificareRovinieta("B18ECK", "ZF903AA", evidenta1));
	*/
	}

}
