package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		
		evidenta.afiseazaRoviniete();
		evidenta.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2018"), 0);
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
		
		
		/**
		 * Rovinieta este in regula, datele sunt corecte dar dupa ce este schimbata data,
		 * devine o problema!
		 */
		Proprietar_masina propMas5 = new Proprietar_masina("Maria Ionete", "29503104455215", "St. Ion Zambristeanu Nr. 14");
		
		propMas5.introducereDate("CL901TBC", "PP892TY", evidenta);
		System.out.println("====================================================");
		Rovinieta temp5 = evidenta.getUltimaRovinieta();
		temp5.afisareDate();
		
		assertTrue(propMas5.verificareRovinieta("CL901TBC", "PP892TY", evidenta));
		
		evidenta.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2018"), 4);
		assertFalse(propMas5.verificareRovinieta("CL901TBC", "PP892TY", evidenta));
		
		/**
		 * Numarul de inmatriculare nu este corect introdus
		 */
		System.out.println("====================================================");
		Proprietar_masina propMas6 = new Proprietar_masina("Ion Necula", "1940324229014", "Bd. Kalinsecu, Nr. 2");
		propMas6.introducereDate("B1902EOPR", "KA103LL", evidenta);
		
		/**
		 * Seria sasiului nu este corect introdusa
		 */
		System.out.println("====================================================");
		Proprietar_masina propMas7 = new Proprietar_masina("Dorinescu Ionela", "2950919442019", "Bd Drumul Taberei, Nr. 3");
		propMas7.introducereDate("B708CJK", "NMKK431OL", evidenta);
		
		/**
		 * Userul are deja o rovinieta, si o verifica.
		 */
		Proprietar_masina propMas8 = new Proprietar_masina("Bidila Timotei", "1970327450029", "Str. Porumbacu, Nr. 5");
		Rovinieta rov = new Rovinieta("B67ERT", "IJ903LK");
		evidenta.adaugaRovinieta(rov);
		System.out.println("====================================================");
		Rovinieta rovTest = evidenta.getUltimaRovinieta();
		rovTest.afisareDate();
		assertTrue(propMas8.verificareRovinieta(rov.getNrInmatriculare(), rov.getSerieSasiu(), evidenta));
		
		/**
		 * Userul are deja o rovinieta, dar este expirata!
		 */
		Proprietar_masina propMas9 = new Proprietar_masina("Daniel Alexandrescu", "1650910993012", "Bd. Ceahlau, Nr. 14");
		Rovinieta rov1 = new Rovinieta("IF901DAN", "EE190RT");
		System.out.println("====================================================");
		rov1.setData(new SimpleDateFormat("dd/MM/yyyy").parse("27/04/2018"));
		evidenta.adaugaRovinieta(rov1);
		rov1.afisareDate();
		assertFalse(propMas9.verificareRovinieta(rov1.getNrInmatriculare(), rov1.getSerieSasiu(), evidenta));		
		
		/**
		 * Userul are o rovinieta, este expirata, dar dupa ce este cumparata una nou(schimbata data) totul este in regula!
		 */
		Proprietar_masina propMas10 = new Proprietar_masina("Dan Constantin", "1850208213775", "Splaiul Unirii, Nr. 32");
		Rovinieta rov2 = new Rovinieta("B309CON", "II298AK");

		System.out.println("====================================================");
		System.out.println("Inainte de cumparare rovinieta noua");
		System.out.println("====================================================");
		rov2.setData(new SimpleDateFormat("dd/MM/yyyy").parse("09/12/2018"));
		evidenta.adaugaRovinieta(rov2);
		rov2.afisareDate();
		assertFalse(propMas10.verificareRovinieta(rov2.getNrInmatriculare(), rov2.getSerieSasiu(), evidenta));

		System.out.println("====================================================");
		System.out.println("Dupa cumparare rovinieta noua: ");
		System.out.println("====================================================");
		
		/** Proprietarul isi cumpara o rovinieta noua, inlocuind data de expirare precedenta */
		evidenta.schimbaData(new Date(), evidenta.getRovinieta().length - 1);
		rov2.setData(evidenta.getUltimaRovinieta().getData());
		rov2.afisareDate();
		assertTrue(propMas10.verificareRovinieta(rov2.getNrInmatriculare(), rov2.getSerieSasiu(), evidenta));
	}

}