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
	 * Bidila Timotei 334 AA Verificare valabilitate rovinieta
	 */
	@Test
	void testVerificareRovinieta() throws ParseException 
	{
		Evidenta evidenta = new Evidenta();
		
		/**
		 *  Rovinieta expirata, dupa ce a fost schimbata data
		 */
		Proprietar_masina propMas1 = new Proprietar_masina("Gigel Ionel", "1860316224495", "Str Caramizilor Nr. 23");
		
		propMas1.introducereDate("B18ECK", "ZF893FQ", evidenta);
		
		evidenta.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2018"), Evidenta.getNrRoviniete() - 1);
		
		assertFalse(propMas1.verificareRovinieta("B18ECK", "ZF893FQ", evidenta));
		
		/**
		 * Rovinieta este in regula, datele sunt corecte
		 */
		Proprietar_masina propMas2 = new Proprietar_masina("Marcel Dan", "19205278913514", "Bd. Ion Mihalache Nr. 14");
		
		propMas2.introducereDate("B20YBC", "JK201AB", evidenta);
		
		assertTrue(propMas2.verificareRovinieta("B20YBC", "JK201AB", evidenta));
		
		/**
		 * Nu a fost introdus cum trebuie numarul de inmatriculare
		 */
		Proprietar_masina propMas3 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas3.introducereDate("B30AAA", "LO901AK", evidenta);
		
		assertFalse(propMas3.verificareRovinieta("B30AAB", "LO901AK", evidenta));
		
		/**
		 * Nu a fost introdusa cum trebuie seria sasiului!
		 */

		Proprietar_masina propMas4 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas4.introducereDate("CT80EAK", "ER572HJ", evidenta);
		
		assertFalse(propMas4.verificareRovinieta("CT80EAK", "LO901AK", evidenta));
		
		
	}

}
