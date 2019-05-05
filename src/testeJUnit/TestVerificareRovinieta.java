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
	void testVerificareRovinieta()
	{
		Evidenta evidenta = new Evidenta();
		
		/**
		 *  Rovinieta expirata, dupa ce a fost schimbata data
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 1");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas1 = new Proprietar_masina("Gigel Ionel", "1860316224495", "Str Caramizilor Nr. 23");
		
		propMas1.introducereDate("B18ECK", "ZF893FQ", evidenta);
		
		// Este nevoie de un bloc try-catch pentru prevenirea oricaror exceptii ce pot aparea in parsarea stringului
		try {
			evidenta.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2018"), 0);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		propMas1.afisareDateRovinieta();
		
		assertFalse(propMas1.verificareRovinieta(propMas1.getRovinieta().getNrInmatriculare(), propMas1.getRovinieta().getSerieSasiu(), evidenta));
		
		/**
		 * Rovinieta este in regula, datele sunt corecte
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 2");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas2 = new Proprietar_masina("Marcel Dan", "19205278913514", "Bd. Ion Mihalache Nr. 14");
		
		propMas2.introducereDate("B20YBC", "JK201AB", evidenta);
		System.out.println("====================================================");
		
		propMas2.afisareDateRovinieta();
		assertTrue(propMas2.verificareRovinieta(propMas2.getRovinieta().getNrInmatriculare(), propMas2.getRovinieta().getSerieSasiu(), evidenta));
		
		/**
		 * Nu corespunde numarul de inmatriculare la verificare.
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 3");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas3 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas3.introducereDate("B30AAA", "LO901AK", evidenta);

		System.out.println("====================================================");
		propMas3.afisareDateRovinieta();
		
		assertFalse(propMas3.verificareRovinieta("B30AAB", propMas3.getRovinieta().getSerieSasiu(), evidenta));
		
		/**
		 * Nu corespunde seria sasiului la verificare.
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 4");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas4 = new Proprietar_masina("Ionescu Tudor", "1890310229012", "Str. Pancului, Nr. 22");
		
		propMas4.introducereDate("CT80EAK", "ER572HJ", evidenta);

		System.out.println("====================================================");
		propMas4.afisareDateRovinieta();
		
		assertFalse(propMas4.verificareRovinieta(propMas4.getRovinieta().getNrInmatriculare(), "AB572HJ", evidenta));
		
		
		/**
		 * Rovinieta este in regula, datele sunt corecte dar dupa ce este schimbata data,
		 * devine o problema!
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 5");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas5 = new Proprietar_masina("Maria Ionete", "29503104455215", "St. Ion Zambristeanu Nr. 14");
		
		propMas5.introducereDate("CL901TBC", "PP892TY", evidenta);
		System.out.println("====================================================");
		
		propMas5.afisareDateRovinieta();
		
		assertTrue(propMas5.verificareRovinieta(propMas5.getRovinieta().getNrInmatriculare(), propMas5.getRovinieta().getSerieSasiu(), evidenta));
		
		// Este nevoie de un bloc try-catch pentru prevenirea oricaror exceptii ce pot aparea in parsarea stringului
		try {
			evidenta.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2018"), 4);
		} catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		assertFalse(propMas5.verificareRovinieta("CL901TBC", "PP892TY", evidenta));
		
		/**
		 * Numarul de inmatriculare nu este corect introdus
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 6");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas6 = new Proprietar_masina("Ion Necula", "1940324229014", "Bd. Kalinescu, Nr. 2");
		propMas6.introducereDate("B1902EOPR", "KA103LL", evidenta);
		
		/**
		 * Seria sasiului nu este corect introdusa
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 7");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas7 = new Proprietar_masina("Dorinescu Ionela", "2950919442019", "Bd Drumul Taberei, Nr. 3");
		propMas7.introducereDate("B708CJK", "NMKK431OL", evidenta);
		
		/**
		 * Userul are deja o rovinieta, si o verifica.
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 8");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas8 = new Proprietar_masina("Bidila Timotei", "1970327450029", "Str. Porumbacu, Nr. 5");
		Rovinieta rov = new Rovinieta("B67ERT", "IJ903LK");
		propMas8.setRovinieta(rov);
		evidenta.adaugaRovinieta(rov);
		System.out.println("====================================================");
		
		propMas8.afisareDateRovinieta();
		
		assertTrue(propMas8.verificareRovinieta(rov.getNrInmatriculare(), rov.getSerieSasiu(), evidenta));
		
		/**
		 * Userul are deja o rovinieta, dar este expirata!
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 9");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas9 = new Proprietar_masina("Daniel Alexandrescu", "1650910993012", "Bd. Ceahlau, Nr. 14");
		Rovinieta rov1 = new Rovinieta("IF901DAN", "EE190RT");
		System.out.println("====================================================");
		
		// Este nevoie de un bloc try-catch pentru prevenirea oricaror exceptii ce pot aparea in parsarea stringului
		try {
			rov1.setData(new SimpleDateFormat("dd/MM/yyyy").parse("27/04/2018"));
		}
		catch ( ParseException e)
		{
			e.printStackTrace();
		}
		
		propMas9.setRovinieta(rov1);
		evidenta.adaugaRovinieta(rov1);
		propMas9.afisareDateRovinieta();
		assertFalse(propMas9.verificareRovinieta(rov1.getNrInmatriculare(), rov1.getSerieSasiu(), evidenta));		
		
		/**
		 * Userul are o rovinieta, este expirata, dar dupa ce este cumparata una nou(schimbata data) totul este in regula!
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 10");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas10 = new Proprietar_masina("Dan Constantin", "1850208213775", "Splaiul Unirii, Nr. 32");
		Rovinieta rov2 = new Rovinieta("B309CON", "II298AK");

		System.out.println("====================================================");
		System.out.println("Inainte de cumparare rovinieta noua");
		System.out.println("====================================================");
		
		// Este nevoie de un bloc try-catch pentru prevenirea oricaror exceptii ce pot aparea in parsarea stringului
		try {
			rov2.setData(new SimpleDateFormat("dd/MM/yyyy").parse("09/12/2018"));
		} catch(ParseException e)
		{
			e.printStackTrace();
		}
		propMas10.setRovinieta(rov2);
		evidenta.adaugaRovinieta(rov2);
		//rov2.afisareDate(); - se putea folosi si aceasta metoda
		propMas10.afisareDateRovinieta();
		assertFalse(propMas10.verificareRovinieta(rov2.getNrInmatriculare(), rov2.getSerieSasiu(), evidenta));

		System.out.println("====================================================");
		System.out.println("Dupa cumparare rovinieta noua: ");
		System.out.println("====================================================");
		
		/** Proprietarul isi cumpara o rovinieta noua, inlocuind data de expirare precedenta */
		evidenta.schimbaData(new Date(), evidenta.getRovinieta().length - 1);
		rov2.setData(evidenta.getUltimaRovinieta().getData());
		rov2.afisareDate();
		assertTrue(propMas10.verificareRovinieta(rov2.getNrInmatriculare(), rov2.getSerieSasiu(), evidenta));
		
		
		/**
		 * Proprietarul are o rovinieta, dar isi cumpara o masina noua care nu are rovinieta!
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 11");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Proprietar_masina propMas11 = new Proprietar_masina("Daniel Mirceanu", "1960309339021", "Str Victoriei, Nr. 141");
		
		Rovinieta rov3 = new Rovinieta("CT809AAK", "IK330JK");
		
		propMas11.setRovinieta(rov3);
		evidenta.adaugaRovinieta(rov3);
		
		assertTrue(propMas11.verificareRovinieta(propMas11.getRovinieta().getNrInmatriculare(), propMas11.getRovinieta().getSerieSasiu(), evidenta));

		evidenta.scoateRovinieta(rov3);
		
		propMas11.getRovinieta().setSerieSasiu("AA999OP");
		
		evidenta.adaugaRovinieta(rov3);		
		
		assertFalse(propMas11.verificareRovinieta(rov3.getNrInmatriculare(), "IK330JK", evidenta));
		
		
		/**
		 * Proprietarul isi modifica numarul de inmatriculare, dar rovinieta veche nu are noul numar.
		 */
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testul 12");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		Proprietar_masina propMas12 = new Proprietar_masina("Stefan Chebor", "1780908228901", "Str Victoriei Nr. 90");
		Rovinieta rov4 = new Rovinieta("B809STF", "JK890QW");
		
		propMas12.setRovinieta(rov4);
		evidenta.adaugaRovinieta(rov4);
		
		assertTrue(propMas12.verificareRovinieta(propMas12.getRovinieta().getNrInmatriculare(), propMas12.getRovinieta().getSerieSasiu(), evidenta));
		
		evidenta.scoateRovinieta(rov4);
		propMas12.getRovinieta().setNrInmatriculare("B109AAK");
		
		evidenta.adaugaRovinieta(rov4);
		
		assertFalse(propMas12.verificareRovinieta("B809STF", propMas12.getRovinieta().getSerieSasiu(), evidenta));
		
	
	}

}