// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

/************************************************************/
/**
 * 
 */
public class Proprietar_masina extends Date_Rovinieta {
	/**
	 * 
	 */
	private String nume;
	/**
	 * 
	 */
	private String cnp;
	/**
	 * 
	 */
	private String adresa;
	/**
	 * 
	 */
	private Rovinieta rovinieta=null;
	
	
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
	 * 
	 */
	public Proprietar_masina(String nume, String cnp, String adresa) {
		this.nume = nume;
		this.cnp = cnp;
		this.adresa = adresa;
	}
	
	public Proprietar_masina(String nume, String cnp, String adresa, Rovinieta rovinieta) {
		this.nume = nume;
		this.cnp = cnp;
		this.adresa = adresa;
		this.rovinieta = rovinieta;
	}
	
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
};
