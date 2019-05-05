package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema2_ISP_CTD.Camera;
import Tema2_ISP_CTD.CanalComunicatie;
import Tema2_ISP_CTD.DispVerificare;
import Tema2_ISP_CTD.Imagine;

class TestTransmisieDate {
	
	@Test
	/**
	 * Testez Imagine cu continut gol #1
	 */
	void testDateDisponibile1() {
		
		Imagine imag2 = new Imagine(" ");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());	
	}
	
	@Test
	/**
	 * Testez Imagine cu continut gol #2
	 */
	void testDateDisponibile2() {
		
		Imagine imag2 = new Imagine("");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());	
	}
	
	@Test
	/**
	 * Caz in care nu am imagine, deci fara sursa de date
	 */
	void testDateDisponibile3() {
		
		Imagine imag2 = new Imagine();
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());
	}
	
	
	@Test
	/**
	 * Caz in care am reperat un nr
	 */
	void testDateDisponibile4() {
		
		Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertTrue(cam2.identificareNrMasina());
	}
	
	@Test
	/**
	 *  Test in care Dispozitivul de verificare are la ce canal sa conecteze
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
	 * Test in care canalul nu se conecteaza la niciun Dispozitiv
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
	
	/**
	 * Test in care camera reuseste sa initieze canalul de comunicatie
	 */
	@Test
	void testConnectareCamera() {
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		//cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		assertTrue(canCom.verificareConnectareCamera());		
	}
	
	
	
	/**
	 * Test initiere canal de comunicatie fara camera
	 */
	@Test
	void testConnectareCamera2() {
	
		Camera cam2 = null;
	
		CanalComunicatie canCom = new CanalComunicatie();
		assertFalse(canCom.verificareConnectareCamera());	
	}	
	
	
	/**
	 * Test initiere canal de comunicatie cu camera null
	 */
	@Test
	void testConnectareCamera3() {
	
		Camera cam2 = null;
	
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		assertFalse(canCom.verificareConnectareCamera());
	}

}
