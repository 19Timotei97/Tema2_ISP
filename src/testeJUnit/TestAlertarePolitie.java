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

class TestAlertarePolitie {

	/**
	 * Cristian-Alexandru Ghihanis 334AA Alertare Politie
	 */
	
	@Test
	/**
	 * Testez accepta date 
	 */
	void testDateDisponibile1() {
		
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
	 *  Testez preluare date
	 */
	void testDateDisponibile2() {
		
		Imagine imag2 = new Imagine("");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());	
	}
	
	@Test
	/**
	 * testare adaugare rovinieta
	 */
	void testDateDisponibile3() {
		
		Imagine imag2 = new Imagine();
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());
	}
	
	
	@Test
	/**
	 *  testare verificare date
	 */
	void testDateDisponibile4() {
		
		Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertTrue(cam2.identificareNrMasina());
	}
	
	@Test
	/**
	 *  test alertare politie
	 */
	void testConnectareDispVCanal1() {
		Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		DispVerificare disp;
		disp = new DispVerificare(canCom);
		
		assertTrue(disp.verificareConnectareDispozitiv());
	}
	
	
	@Test
	/**
	 * Test primire semnal -> true daca (departament != null || departament != "")
	 */
	void testConnectareDispVCanal2() {
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		//cam2.capturareImagine(imag2);
		//CanalComunicatie canCom = new CanalComunicatie();
		DispVerificare disp;
		
		//In cazul asta  nu avem canal de comunicatie
		disp = new DispVerificare();
		
		assertFalse(disp.verificareConnectareDispozitiv());
	}

}
