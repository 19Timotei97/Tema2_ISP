// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/************************************************************/
/**
 * 
 */
public class Proprietar_masina extends Date_Rovinieta {

	private String nume;

	private String cnp;

	private String adresa;

	private Rovinieta rovinieta = null;
	
	/**
	 * Getteri, respectiv setteri pentru fiecare atribut
	 */
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Rovinieta getRovinieta() {
		if(rovinieta != null) return rovinieta;
		return null;
	}

	public void setRovinieta(Rovinieta rovinieta) {
		this.rovinieta = rovinieta;
	}

	/**
	 * Constructor ce primeste datele unui proprietar
	 */
	public Proprietar_masina(String nume, String cnp, String adresa) {
		this.nume = nume;
		this.cnp = cnp;
		this.adresa = adresa;
	}
	
	/**
	 * Constructor care pe langa parametrii constructorului de mai sus, mai primeste si un parametru rovinieta
	 */
	public Proprietar_masina(String nume, String cnp, String adresa, Rovinieta rovinieta) {
		this.nume = nume;
		this.cnp = cnp;
		this.adresa = adresa;
		this.rovinieta = rovinieta;
	}
	
	/**
	 * Metoda prin care se afiseaza datele proprietarului precum si ale rovinietei sale
	 */
	void afisare() {
		System.out.println("Detalii proprietar masina!");
		System.out.println("Nume: " + nume);
		System.out.println("CNP: " + cnp);
		System.out.println("Adresa: " + adresa);
		if(rovinieta != null) {
			System.out.println("Rovinieta: ");
			this.rovinieta.afisareDate();
		}
	}
	
	/**
	 * Metoda utilizata pentru a introduce datele intr-o evidenta cu toate rovinietele.
	 * Daca rovinieta nu exista, se va crea una.
	 * Daca sasiul scris in rovinieta este acelasi cu cel introdus si rovinietea nu este expirata, se va returna true.
	 * Daca sasiul scris in rovinieta este acelasi cu cel introdus, rovinieta nu este expirata
	 * Altfel, se seteaza datele introduse
	 */
	public boolean introducereDate(String nrInmatriculare, String serieSasiu, Evidenta evidenta) {
		if(rovinieta == null) {
			if(evidenta.rovinietaExista(serieSasiu) == false) {
				Rovinieta temp = new Rovinieta(nrInmatriculare, serieSasiu, 99);
				evidenta.adaugaRovinieta(temp);
				
				this.rovinieta = temp;
			}
		} else if( this.rovinieta.getSerieSasiu().equals(serieSasiu) == true && evidenta.rovinietaExpirata(serieSasiu) == false) return true;
		else if(this.rovinieta.getSerieSasiu().equals(serieSasiu) == true) this.rovinieta.setIsExpired(false);
		else {
			this.rovinieta.setNrInmatriculare(nrInmatriculare);
			this.rovinieta.setSerieSasiu(serieSasiu);
			this.rovinieta.setIsExpired(false);
		}
		return false;
	}
	
	/*
	 * Metoda prin care un proprietar isi poate verifica Rovinieta. Se introduc nr de inmatriculare, seria sasiului si se mai accepta si un parametru
	 * de tip evidenta, in care se va cauta rovinieta.
	 */
	public boolean verificareRovinieta(String nrInmatriculare, String serieSasiu, Evidenta evidenta) 
	{
		Rovinieta temp = new Rovinieta(nrInmatriculare, serieSasiu);
		Date date;
		try {
			date = new Date();
			temp.setData(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(Calendar.getInstance().get(Calendar.YEAR) == temp.getData().getYear()) {
			if(((Calendar.getInstance().get(Calendar.MAY)) + 1) - (temp.getData().getMonth() + 1) < 6)
				temp.setIsExpired(false);
		}
		else temp.setIsExpired(false);
		if(evidenta.rovinietaExista(serieSasiu)) {
			if(!evidenta.rovinietaExpirata(serieSasiu))
			{
				System.out.println("Rovinieta exista si nu a expirat!");
				return true;
			}
		}
		
		else 
		{
			System.out.println("Rovinieta expirata! Un echipaj de politie apropiat va fi alertat!");
			return false;
		}
		return false;
	}
};
