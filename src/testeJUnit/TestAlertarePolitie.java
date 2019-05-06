package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema2_ISP_CTD.Camera;
import Tema2_ISP_CTD.CanalComunicatie;
import Tema2_ISP_CTD.DispVerificare;
import Tema2_ISP_CTD.Evidenta;
import Tema2_ISP_CTD.Imagine;
import Tema2_ISP_CTD.Organ_politie;
import Tema2_ISP_CTD.Rovinieta;
import java.util.*;  

class TestAlertarePolitie {

	/**
	 * Cristian-Alexandru Ghihanis 334AA Alertare Politie
	 */
	
	@Test
	/**
	 * Testez modul de acceptare al datelor de catre dispozitivul de verificare, atunci cand primeste date de la o camera
	 */
	void testAcceptareDate() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 1");
		System.out.println("**********************************************************/");
		
		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		disp.acceptareDate();	
		assertTrue(disp.acceptareDate());
	}
	
	@Test
	/**
	 *  Testez modalitatea de preluare interna a datelor de catre Dispozitivul de verificare
	 *  Metoda verifica daca numarul de inmatriculare exista, si daca acesta este asociat unei
	 *  serii de sasiu
 	 */
	void testPreluareDateRovinieta() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 2");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		
		assertTrue(disp.preluareDateRovinieta(imag2.getNrMasina()));
			
	}
	
	@Test
	/**
	 * Testez metoda de adaugareRovinieta, cea care se ocupa de actualizarea listei de roviniete verificate de catre 
	 * dispozitivul de verificare.
	 * Aceasta testeaza daca rovinieta exista in evidenta inainte de a o adauga
	 */
	void testActualizareLista() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 3");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		
		// metoda care realizeaza adaugarea rovinietei verificate in istoricul de roviniete al dispozitivului de verificare
		assertTrue(disp.adaugaRovinieta(r2));
		
	}
	
	
	@Test
	/**
	 *  Testez metoda de decodificareSemnal. Aceasta ilustreaza rezultatul luat de metoda verificareRovinieta 
	 *  care se ocupa de partea de decizie pentru validarea datelor.
	 *  Pentru valorile 2 si 3 aceasta intoarce false (rovinieta incorecta / expirata), iar pentru valoare 1, aceasta
	 *  updateaza lista de roviniete din dispozitiv
	 */
	void testDecodificareSemnal() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 4");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		
		assertTrue( disp.decodificareSemnal(disp.verificareRovinieta("B22CCC", "352sdf")) );
		
	}
	
	@Test
	/**
	 * Testez metoda verificareProximitate, care verifica locatia celei mai apropiate sectii e politie pentru trimiterea unui echipaj de politie 
	 * dupa proprietarul cu masina fara rovinieta
	 * Testul esueaza daca campul HashMap din dispozitivul de verificare este gol. Altfel, alege cea mai apropiata statie. 
	 */
	void testVerificareProximitatePolitie() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 5");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "t353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Damocles", 10);
		disp.setDistante(map);
		
		assertTrue( disp.verificareProximitatePolitie() );
	}
	
	@Test
	/**
	 *  Testez metoda alertarePolitie care verifica daca locatia respectiva este valabila si, daca da, trimite o alerta
	 *  catre centrul respectiv
	 */
	void testAlertarePolitie() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 6");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		
		assertTrue( disp.alertarePolitie("Bahamas", 20) );
		
	}
	
	
	@Test
	/**
	 * Testez metoda primireSemnal care ilustreaza momentul primirii semnalului de alerta de la un dispozitiv de verificare
	 * si, in cazul in care este ok, directioneaza un politist pentru sanctionare
	 */
	void testPrimireSemnalPolitie() {
		
		System.out.println("/**********************************************************");
		System.out.println("Testul 7");
		System.out.println("**********************************************************/");

		DispVerificare disp = new DispVerificare();
		Rovinieta r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		Rovinieta r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		Rovinieta r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		Evidenta evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B22CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		Organ_politie op1 = new Organ_politie();
		
		assertTrue( op1.primireSemnal("Bahamas") );
	}

	
}
