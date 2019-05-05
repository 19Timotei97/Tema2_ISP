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
		Rovinieta temp1 = evidenta.getUltimaRovinieta();
		temp1.afisareDate();
		assertFalse(propMas1.verificareRovinieta("B18ECK", "ZF893FQ", evidenta));
		
		/**
		 * Rovinieta este in regula, datele sunt corecte
		 */
		Proprietar_masina propMas2 = new Proprietar_masina("Marcel Dan", "19205278913514", "Bd. Ion Mihalache Nr. 14");
		
		propMas2.introducereDate("B20YBC", "JK201AB", evidenta);
		System.out.println("====================================================");
		Rovinieta temp2 = evidenta.getUltimaRovinieta();
		temp2.afisareDate();
		assertTrue(propMas2.verificareRovinieta("B20YBC", "JK201AB", evidenta));
		
		/**
		 * Nu corespunde numarul de inmatriculare la verificare.
		 */
		Proprietar_masina propMas3 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas3.introducereDate("B30AAA", "LO901AK", evidenta);

		System.out.println("====================================================");
		Rovinieta temp3 = evidenta.getUltimaRovinieta();
		temp3.afisareDate();
		
		assertFalse(propMas3.verificareRovinieta("B30AAB", "LO901AK", evidenta));
		
		/**
		 * Nu corespunde seria sasiului la verificare.
		 */

		Proprietar_masina propMas4 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas4.introducereDate("CT80EAK", "ER572HJ", evidenta);

		System.out.println("====================================================");
		Rovinieta temp4 = evidenta.getUltimaRovinieta();
		temp4.afisareDate();
		assertFalse(propMas4.verificareRovinieta("CT80EAK", "AB572HJ", evidenta));
		
		
		
	}

}
