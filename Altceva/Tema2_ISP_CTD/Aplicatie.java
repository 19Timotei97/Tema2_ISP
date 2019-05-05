package Tema2_ISP_CTD;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aplicatie {

	public static void main(String[] args) {

		/*Proprietar_masina propMas2 = new Proprietar_masina("Marcel Dan", "19205278913514", "Bd. Ion Mihalache Nr. 14");
		Evidenta evidenta1 = new Evidenta();
		Rovinieta rov = new Rovinieta("B20YBC", "JK201AB");
		rov.afisareDate();
		*/
		
		
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
		r1 = new Rovinieta("B22CCC", "352sdf");
		r2 = new Rovinieta("B33CCC", "353sdf");
		r3 = new Rovinieta("B44CCC", "354sdf");
		
		evid = new Evidenta();
		
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);
		evid.adaugaRovinieta(r3);
		//evid.afiseazaRoviniete();
		
		disp.adaugaRovinieta(r1);
		disp.adaugaRovinieta(r2);
		disp.adaugaRovinieta(r3);
		
		disp.setEvidenta(evid);
		//disp.getEvidenta().afiseazaRoviniete();
		//System.out.println("\n\n");
		//disp.listaRoviniete();
		//System.out.println("\n\n");
		if(disp.preluareDateRovinieta("B33CCC"));
		//System.out.println(evid.getSerieSasiu("B33CCC"));
		
		
		
		System.out.println("Dispozitivul politistului afiseaza rovinietele");
		oPolitie1.getDispVerif().listaRoviniete();
		oPolitie1.setDispVerif(disp);
		oPolitie1.getDispVerif().listaRoviniete();
		
		
		
		propMas1 = new Proprietar_masina("Citi","01241124","Bd Cismigiu");
		propMas1.introducereDate("B55CCC", "365sdf", evid);
		propMas1.verificareRovinieta("B22CCC", "352sdf", evid);
		//propMas1.getRovinieta().afisareDate();
		
		System.out.println("Verificare clasa Imagine");
		imag1 = new Imagine("B33CCC");
		System.out.println(imag1.getNrMasina());
		System.out.println("\n\n\n");
		
		System.out.println("Verificare clasa Camera");
		cam1= new Camera("C2");
		cam1.capturareImagine(imag1);
		cam1.identificareNrMasina();
		System.out.println(cam1.transmitereDate(disp)); 
		//System.out.println("\n\n\n");
		
		/*
		oPolitie1.verificareRovinieta("nasdfkjn", "afadsfsdf");
		s1 = new Sanctiune("ceva","" , "Bd Dimitrie Cantemir, Nr. 5");
		System.out.println(s1.getLoc());
		*/
	}

}
