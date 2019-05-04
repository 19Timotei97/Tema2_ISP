package Tema2_ISP_CTD;

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
		oPolitie1 = new Organ_politie("Gigel", disp);
		r1 = new Rovinieta("B22CCC", "352sdf", 1);
		r2 = new Rovinieta("B33CCC", "353sdf", 2);
		r3 = new Rovinieta("B44CCC", "354sdf", 3);
		
		evid = new Evidenta();
		evid.adaugaRovinieta(r1);
		evid.adaugaRovinieta(r2);	
		evid.adaugaRovinieta(r3);
		
		evid.afiseazaRoviniete();
		
		
		disp.adaugaRovinieta(r1);
		disp.adaugaRovinieta(r2);
		disp.adaugaRovinieta(r3);
		disp.listaRoviniete();
		disp.scoateRovinieta(r2);
		disp.listaRoviniete();
		
		oPolitie1.getDispVerif().listaRoviniete();
		oPolitie1.setDispVerif(disp);
		oPolitie1.getDispVerif().listaRoviniete();
		
		
		
		propMas1 = new Proprietar_masina("Citi","01241124","Bd Cismigiu");
		propMas1.introducereDate("B55CCC", "365sdf", evid);
		propMas1.getRovinieta().afisareDate();
		
		imag1 = new Imagine("Imag1");
		System.out.println(imag1.getNrMasina());
		cam1= new Camera("C2");
		cam1.capturareImagine(imag1);
		cam1.identificareNrMasina();
		System.out.println(cam1.transmitereDate()); 
		
		oPolitie1.verificareRovinieta("nasdfkjn", "afadsfsdf", evid);
		s1 = new Sanctiune("ceva", "ceva", "ceva");
		System.out.println(s1.getLoc());
		
	}

}
