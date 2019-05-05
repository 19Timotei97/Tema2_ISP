package Tema2_ISP_CTD;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Aplicatie {

	public static void main(String[] args) {

		Proprietar_masina propMas2 = new Proprietar_masina("Marcel Dan", "19205278913514", "Bd. Ion Mihalache Nr. 14");
		Evidenta evidenta1 = new Evidenta();
		
		
		propMas2.introducereDate("B20YBC", "JK201AB", evidenta1);

		//evidenta1.afiseazaRoviniete();
		try {
			evidenta1.schimbaData(new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2018"), 0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		evidenta1.afiseazaRoviniete();
		propMas2.verificareRovinieta("B20YBC", "JK201AB", evidenta1);
	/*
		Organ_politie oPolitie1;
		Proprietar_masina propMas1;
		Camera cam1;
		DispVerificare disp;
		Rovinieta r1,r2,r3;
		Sanctiune s1;
		Imagine imag1;
		Evidenta evid;
		
		disp = new DispVerificare();
		oPolitie1 = new Organ_politie("Gigel", disp);
		r1 = new Rovinieta("B22CCC", "352sdf", 1);
		r2 = new Rovinieta("B33CCC", "353sdf", 2);
		r3 = new Rovinieta("B44CCC", "354sdf", 3);
		
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
		
		oPolitie1.getDispVerif().listaRoviniete();
		oPolitie1.setDispVerif(disp);
		oPolitie1.getDispVerif().listaRoviniete();
		
		
		
		propMas1 = new Proprietar_masina("Citi","01241124","Bd Cismigiu");
		propMas1.introducereDate("B55CCC", "365sdf", evid);
		propMas1.verificareRovinieta("B22CCC", "352sdf", evid);
		//propMas1.getRovinieta().afisareDate();
		
		System.out.println("Verificare clasa Imagine");
		imag1 = new Imagine("Imag1");
		System.out.println(imag1.getNrMasina());
		System.out.println("\n\n\n");
		
		System.out.println("Verificare clasa Camera");
		cam1= new Camera("C2");
		cam1.capturareImagine(imag1);
		cam1.identificareNrMasina();
		System.out.println(cam1.transmitereDate()); 
		System.out.println("\n\n\n");
		
		oPolitie1.verificareRovinieta("nasdfkjn", "afadsfsdf", evid);
		s1 = new Sanctiune("ceva","" , "Bd Dimitrie Cantemir, Nr. 5");
		System.out.println(s1.getLoc());
		*/
	}

}
