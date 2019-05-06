// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/************************************************************/
/**
 * 
 */
public class Proprietar_masina extends Date_Rovinieta {
	
	/**
	 * Date folosite pentru identificarea proprietarului
	 */
	private String nume;

	private String cnp;

	private String adresa;
	
	/**
	 * Si are asociata si o rovinieta, inital nula
	 */
	private Rovinieta rovinieta = null;

	
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
	 * Metoda prin care se afiseaza datele proprietarului precum si ale rovinietei sale
	 */
	public void afisare() {
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
	 *  Se cheama functia de afisare a datelor rovinietei detinuta de proprietar
	 */
	public void afisareDateRovinieta()
	{
		if(rovinieta != null)
			rovinieta.afisareDate();
	}
	
	/**
	 * Metoda utilizata pentru a introduce datele intr-o evidenta cu toate rovinietele.
	 * Daca rovinieta nu exista, se va crea una si se va adauga in evidenta
	 * Daca sasiul scris in rovinieta este acelasi cu cel introdus si rovinietea nu este expirata, se va returna true.
	 * Daca sasiul scris in rovinieta este acelasi cu cel introdus, si rovinieta este expirata, inseamna ca proprietarul isi reinnoieste rovinieta
	 * @throws ParseException 
	 */
	public boolean introducereDate(String nrInmatriculare, String serieSasiu, Evidenta evidenta){
		if(rovinieta == null && evidenta != null) {
			if(nrInmatriculare.length() > 0 && nrInmatriculare.length() <= 8 && serieSasiu.length() > 0 && serieSasiu.length() <= 7) {
				if(evidenta.rovinietaExista(serieSasiu, "sasiu") == false) 
				{
					Rovinieta temp = new Rovinieta(nrInmatriculare, serieSasiu);
		
					evidenta.adaugaRovinieta(temp);
				
					this.rovinieta = temp;
				}
			}
			else if(nrInmatriculare.length() > 8) System.out.println("Nu este corect numarul de inmatriculare!");
			else if(serieSasiu.length() > 7) System.out.println("Nu este corecta seria sasiului!");
			else System.out.println("Va rugam sa reintroduceti datele!");
		} else if( this.rovinieta.getSerieSasiu().equals(serieSasiu) == true && evidenta.rovinietaExpirata(serieSasiu) == false) return true;
		else if(this.rovinieta.getSerieSasiu().equals(serieSasiu) == true && evidenta.rovinietaExpirata(serieSasiu) == true) this.rovinieta.setIsExpired(false);
		else {
			this.rovinieta.setNrInmatriculare(nrInmatriculare);
			this.rovinieta.setSerieSasiu(serieSasiu);
			this.rovinieta.setIsExpired(false);
			evidenta.adaugaRovinieta(rovinieta);
		}
return false;
	}
	
	/**
	 * Metoda prin care un proprietar isi poate verifica Rovinieta. Se introduc nr de inmatriculare, seria sasiului si se mai accepta si un parametru
	 * de tip evidenta, in care se va cauta rovinieta.
	 */
	public boolean verificareRovinieta(String nrInmatriculare, String serieSasiu, Evidenta evidenta) 
	{
		Rovinieta temp = evidenta.getUltimaRovinieta();
		
		if(temp == null) {
			System.out.println("Rovinieta nu exista in evidenta si a fost creata!");
			temp = new Rovinieta(nrInmatriculare, serieSasiu);
			evidenta.adaugaRovinieta(temp);
		}
		
		/**
		 * Acelasi workaround folosit si in setData din clasa Rovinieta 
		 */
		Date date = temp.getData();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
				
		if(Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
			if(((Calendar.getInstance().get(Calendar.MONTH)) + 1) - (cal.get(Calendar.MONTH) + 1) < 6)
				temp.setIsExpired(false);
			else temp.setIsExpired(true);
		}
		else temp.setIsExpired(true);
		
		if(evidenta.rovinietaExista(serieSasiu, "sasiu")) {
			if(temp.getSerieSasiu() == serieSasiu) 
			{
				if(temp.getNrInmatriculare().equals(nrInmatriculare)) 
				{
					if(!evidenta.rovinietaExpirata(serieSasiu)) 
					{
						System.out.println("Rovinieta este in termen. Circulati cu atentie!");
						return true;
					}
					else 
					{
						System.out.println("Rovinieta expirata! Aveti grija sa o refaceti cat de curand!");
						return false;
					}
				}
				else
				{
					System.out.println("Numarul de inmatriculare nu a fost introdus cum trebuie!");
					return false;
				}
			}
			System.out.println("Seria sasiului nu a fost introdusa cum trebuie!");
			return false;
		}
		
		return false;
	}
};
