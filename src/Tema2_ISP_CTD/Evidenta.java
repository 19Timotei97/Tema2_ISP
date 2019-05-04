// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

/************************************************************/
/**
 * 
 */
public class Evidenta {
	/**
	 * Vectorul de roviniete in care se vor adauga, cauta sau scoate roviniete verificare sau noi
	 */
	private Rovinieta[] rovinieta;
	/**
	 * Intrucat se doreste ca numarul de roviniete sa fie acelasi pentru fiecare instanta a clasei Evidenta,
	 * am hotarat sa il declaram static.
	 */
	private static int nrRovinieta =0;

	/**
	 * Constructor de baza
	 */
	public Evidenta(){
		this.rovinieta = null;
	}
	
	/**
	 * Getteri si setteri pentru fiecare atribut in parte
	 */
	public Rovinieta[] getRovinieta() {
		return this.rovinieta;
	}

	public void setRovinieta(Rovinieta[] rovinieta, int lungime) {
		this.rovinieta = new Rovinieta[lungime];
		for(int i=0; i<lungime; ++i) {
			this.rovinieta[i] = rovinieta[i];
			nrRovinieta = nrRovinieta +1;
		}
	}
	
	public static int getNrRoviniete() {
		return nrRovinieta;
	}
	
	
	public void afiseazaRoviniete() {
		for(int i=0; i<nrRovinieta; ++i)
			rovinieta[i].afisareDate();
	}
	
	/**
	 * 
	 * 
	 */
	public void adaugaRovinieta(Rovinieta rovinieta) {
		
		if(nrRovinieta > 1) {
			//nrRov =2
			nrRovinieta = nrRovinieta +1; //nrRov = 3
			Rovinieta temp[] = new Rovinieta[nrRovinieta]; 
			
			for(int i=0; i<nrRovinieta-1; ++i)
				temp[i] = this.rovinieta[i];
			
			temp[nrRovinieta-1] = rovinieta;
			
			this.rovinieta = new Rovinieta[nrRovinieta];
			
			for(int i=0; i<nrRovinieta; ++i)
				this.rovinieta[i] = temp[i];
		} 
		else if(nrRovinieta == 1)
		{
			nrRovinieta = nrRovinieta +1;
			Rovinieta temp = this.rovinieta[nrRovinieta-2];
			
			this.rovinieta = new Rovinieta[nrRovinieta]; //marit spatiul la 2
			this.rovinieta[nrRovinieta -2] = temp;       // pe 0 punem temp
			this.rovinieta[nrRovinieta -1] = rovinieta;  // pe 1 punem rovinieta pe care o vrem
		} 
		else {
			nrRovinieta = nrRovinieta +1;
			this.rovinieta = new Rovinieta[nrRovinieta]; //aloc 1 spatiu
			this.rovinieta[nrRovinieta-1] = rovinieta;   // pun pe pozitia 1-1=0 pe rovinieta
		}
		
	}
	
	/**
	 * Metoda ce va fi folosita daca se doreste scoaterea din Evidenta a unei roviniete 
	 */
	public boolean scoateRovinieta(Rovinieta rovinieta) {
		boolean ok=false;
		for(int i=0; i<nrRovinieta; ++i) {
			if(ok) {
				this.rovinieta[i-1] = this.rovinieta[i];
			}
			if(this.rovinieta[i] == rovinieta)
				ok=true;
		}
		if(ok) {
			nrRovinieta = nrRovinieta -1;
			return true;
		}
		else return false;
	}
	
	/**
	 * Metoda ce va fi folosita pentru a scoate o rovinieta de pe o anumita pozitie
	 */
	public boolean scoateRovinieta(int numar) {
		if(numar < nrRovinieta) {
			for(int i=numar+1; i<nrRovinieta; ++i) {
				this.rovinieta[i-1] = this.rovinieta[i];
			}
			return true;
		}
		else return false;
	}
	
	/**
	 * Metoda folosita pentru a verifica existenta unei roviniete in evidenta
	 * Se utilizeaza seria sasiului automobilului pentru care este inregistrat rovinieta
	 * @param serieSasiu
	 * @return
	 */
	public boolean rovinietaExista(String serieSasiu) {
		if(nrRovinieta != 0) {
			System.out.println(nrRovinieta);
			this.afiseazaRoviniete();
			for(int i=0; i<nrRovinieta; ++i) {
				System.out.println(rovinieta[i].getSerieSasiu());
				
				if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) ) {
					System.out.println("rovinietaExista() -> Rovinieta are serieSasiu la fel");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean rovinietaExpirata(String serieSasiu) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) ) {
				System.out.println("rovinietaExpirata() -> Rovinieta are serieSasiu la fel");
				if(rovinieta[i].getIsExpired()) return true;
			}
		}
		return false;
	}
	
	public String getNrInmatriculare(String serieSasiu) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) )
				return rovinieta[i].getNrInmatriculare();
		}
		return "";
	}

	public Rovinieta getRovinieta(int i) 
	{
		if(rovinieta != null && i > 0 && i < rovinieta.length)
			return rovinieta[i];
		return null;
	}
};
