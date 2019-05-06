package Tema2_ISP_CTD;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *	Clasa Aplicatie a fost creata pentru a teste implementarea metodelor
 * ce sunt folosite intr-un scenariu clasic de utilizare
 */
public class Aplicatie {

	public static void main(String[] args) {

		Organ_politie oPolitie1;
		Proprietar_masina propMas1;
		Camera cam1;
		DispVerificare disp;
		Rovinieta r1,r2,r3;
		Sanctiune s1;
		Imagine imag1;
		Evidenta evid;
		
		disp = new DispVerificare();
		r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		disp.setEvidenta(evid);
		
		Imagine imag2 = new Imagine("B25CCC");
		Camera cam2 = new Camera("C2");
		cam2.capturareImagine(imag2);
		cam2.identificareNrMasina();
		CanalComunicatie can = new CanalComunicatie(cam2);
		disp.setCanal(can);
		disp.acceptareDate();
			
		System.out.println("*************************************************\n\n");
		
		disp = new DispVerificare();
		oPolitie1 = new Organ_politie("Gigel", disp);
		r1 = new Rovinieta("B22CCC", "352sdf", 15001l);
		r2 = new Rovinieta("B33CCC", "353sdf", 15002l);
		r3 = new Rovinieta("B44CCC", "354sdf", 15003l);
		
		evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		
		System.out.println("Evidenta afiseaza rovinietele");
		evid.afiseazaRoviniete();
		System.out.println("\n\n");
		
		
		disp.adaugaRovinieta(r1);
		disp.adaugaRovinieta(r2);
		disp.adaugaRovinieta(r3);
		System.out.println("Dispozitivul afiseaza rovinietele");
		disp.listaRoviniete();
		System.out.println("\n\n");
		disp.scoateRovinieta(r2);
		System.out.println("Dispozitivul afiseaza rovinietele");
		disp.listaRoviniete();
		System.out.println("\n\n");
		
		try {
			evid.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2018"), 0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r1.afisareDate();
		
		
		oPolitie1.getDispVerif().listaRoviniete();
		oPolitie1.setDispVerif(disp);
		oPolitie1.getDispVerif().listaRoviniete();
		
		
		
		propMas1 = new Proprietar_masina("Citi","01241124","Bd Cismigiu");
		propMas1.introducereDate("B55CCC", "365sdf", evid);
		propMas1.verificareRovinieta("B22CCC", "352sdf", evid);
		propMas1.afisareDateRovinieta();
		
		System.out.println("Verificare clasa Imagine");
		imag1 = new Imagine("B22CCC");
		System.out.println(imag1.getNrMasina());
		System.out.println("\n\n\n");
		
		System.out.println("Verificare clasa Camera");
		cam1= new Camera("C2");
		cam1.capturareImagine(imag1);
		cam1.identificareNrMasina();
		System.out.println(cam1.getNrInmatriculare()); 
		System.out.println("\n\n\n");
		
		oPolitie1.verificareRovinieta("nasdfkjn", "afadsfsdf");
		s1 = new Sanctiune("ceva","" , "Bd Dimitrie Cantemir, Nr. 5");
		System.out.println(s1.getLoc());
	}

}
