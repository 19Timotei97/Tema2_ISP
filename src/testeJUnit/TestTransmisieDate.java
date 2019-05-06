package testeJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Tema2_ISP_CTD.Camera;
import Tema2_ISP_CTD.CanalComunicatie;
import Tema2_ISP_CTD.DispVerificare;
import Tema2_ISP_CTD.Evidenta;
import Tema2_ISP_CTD.Imagine;

class TestTransmisieDate {
	
	/**
	 * Dan Moldovan 334AA Transmitere date
	 */

	@Test
	//Testez Imagine cu continut gol #1
	void testDateDisponibile1() {
		System.out.println("Test1: ");
		Imagine imag2 = new Imagine(" ");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());	
	}
	
	@Test
	//Testez Imagine cu continut gol #2
	void testDateDisponibile2() {
		
		System.out.println("Test2: ");
		
		Imagine imag2 = new Imagine("");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());	
	}
	
	@Test
	//Caz in care nu am imagine, deci fara sursa de date
	void testDateDisponibile3() {
		
		System.out.println("Test3: ");
		
		Imagine imag2 = new Imagine();
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());
	}
	
	
	@Test
	//Caz in care am reperat un nr
	
	void testDateDisponibile4() {
		System.out.println("Test4 : ");
		
		Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		
		cam2.capturareImagine(imag2);
		assertTrue(cam2.identificareNrMasina());
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		DispVerificare disp;
		
		disp = new DispVerificare(canCom);

		disp.acceptareDate();
	}
	
	@Test
	// Test in care Dispozitivul de verificare are la ce canal sa conecteze
	void testConnectareDispVCanal1() {
		
		System.out.println("Test5: ");
		Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		DispVerificare disp;
		disp = new DispVerificare(canCom);
		
		
		assertTrue(disp.verificareConnectareDispozitiv());
	}
	
	@Test
	//Test in care canalul nu se conecteaza la niciun Dispozitiv
	void testConnectareDispVCanal2() {
		System.out.println("Test6: ");
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		//cam2.capturareImagine(imag2);
		//CanalComunicatie canCom = new CanalComunicatie();
		DispVerificare disp;
		
		//In cazul asta  nu avem canal de comunicatie
		disp = new DispVerificare();
		
		assertFalse(disp.verificareConnectareDispozitiv());
	}
	
	@Test
	//Test in care camera reuseste sa initieze canalul de comunicatie
	void testConnectareCamera() {
		
		System.out.println("Test7: ");
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = new Camera("C2");
		//cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		assertTrue(canCom.verificareConnectareCamera());
	}
	
	@Test
	//Test initiere canal de comunicatie fara camera
	void testConnectareCamera2() {
		
		System.out.println("Test8: ");
		
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = null;
		//cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie();
		assertFalse(canCom.verificareConnectareCamera());		
	}

	
	@Test
	//Test initiere canal de comunicatie cu camera null
	void testConnectareCamera3() {
		
		System.out.println("Test9: ");
		//Imagine imag2 = new Imagine("VN22MOL");
		Camera cam2 = null;
		//cam2.capturareImagine(imag2);
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		assertFalse(canCom.verificareConnectareCamera());
		
	}
	
	@Test
	void testDateDisponibile10() {
		
		System.out.println("Test10 : ");
		
		Imagine imag2 = new Imagine("Mara are mere");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		DispVerificare disp;
		disp = new DispVerificare(canCom);
		disp.acceptareDate();	
	}
	
	@Test
	// Caz in care nr de Inmatriculare e dat cu litere mici, trebuie sa dea fail
	void testDateDisponibile11() {
		
		System.out.println("Test11 : ");
		
		Imagine imag2 = new Imagine("vn11mol");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		assertFalse(cam2.identificareNrMasina());
		CanalComunicatie canCom = new CanalComunicatie(cam2);
		DispVerificare disp;
		disp = new DispVerificare(canCom);
		disp.acceptareDate();
		
	}
}
