// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

import java.util.Calendar;
import java.util.Date;

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
	private int nrRovinieta =0;

	/**
	 * Constructor de baza
	 */
	public Evidenta(){
		this.rovinieta = null;
	}
	
	/**
	 * Constructor de cu params
	 */
	public Evidenta(Rovinieta[] Rov, int lungime){
		this.setRovinieta(Rov, lungime);
	}
	
	/**
	 * Constructor de cu params
	 */
	public Evidenta(Evidenta evid){
		this(evid.getRovinieta(), evid.getNrRoviniete());
	}
	
	
	/**
	 * Getteri si setteri pentru fiecare atribut in parte
	 */
	public Rovinieta[] getRovinieta() {
		return this.rovinieta;
	}

	public Rovinieta getRovinieta(int i) {
		return this.rovinieta[i];
	}
	
	public void setRovinieta(Rovinieta[] rovinieta, int lungime) {
		this.rovinieta = new Rovinieta[lungime];
		nrRovinieta =0;
		
		for(int i=0; i<lungime; ++i) {
			this.rovinieta[i] = rovinieta[i];
			nrRovinieta = nrRovinieta +1;
		}
	}
	
	public void setRovinieta(Rovinieta rov, int poz) {
		if(rovinieta != null)
		this.rovinieta[poz] = rov;
	}
	
	public void setNrRoviniete(int nr) {
		if(nrRovinieta == 0) rovinieta = new Rovinieta[nr];
		this.nrRovinieta = nr;
	}
	
	public int getNrRoviniete() {
		return nrRovinieta;
	}
	
	public void schimbaData(Date date, int i)
	{
		if(rovinieta != null)
			rovinieta[i].setData(date);
		
		if(new Date().getYear() == rovinieta[i].getData().getYear()) {
			if(new Date().getMonth() - rovinieta[i].getData().getMonth() < 6)
				rovinieta[i].setIsExpired(false);
		}
		else rovinieta[i].setIsExpired(true);
	}
	
	
	public void afiseazaRoviniete() 
	{
		if(rovinieta != null && nrRovinieta > 0)
			for(int i=0; i<nrRovinieta; ++i)
				rovinieta[i].afisareDate();
	}
	
	
	
	/**
	 * Metoda folosita pentru a verifica existenta unei roviniete in evidenta
	 * Se utilizeaza seria sasiului automobilului pentru care este inregistrat rovinieta
	 * @param serieSasiu
	 * @return
	 */
	public boolean rovinietaExista(String str, String optiune) 
	{
		
		if(optiune.equals("sasiu")) {
			if(nrRovinieta != 0) {
				if(nrRovinieta != 0 && rovinieta != null) 
				{
					for(int i=0; i<nrRovinieta; ++i) {
						if( str.equals( rovinieta[i].getSerieSasiu() ) ) {
							
							return true;
						}
					}
				}
			}
		}
		else if(optiune.equals("inmatr")) {
			if(nrRovinieta != 0) {
				if(nrRovinieta != 0 && rovinieta != null) 
				{
					for(int i=0; i<nrRovinieta; ++i) {
						if( str.equals( rovinieta[i].getNrInmatriculare() ) ) 
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean rovinietaExpirata(String serieSasiu) {
		
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) ) {
				
				System.out.println("\n\n");
				rovinieta[i].afisareDate();
				Date date = rovinieta[i].getData();
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(date);

		        if(Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
		            System.out.println("La ani!");
		        	if(((Calendar.getInstance().get(Calendar.MONTH)) + 1) - (cal.get(Calendar.MONTH) + 1) < 6) {
		            	System.out.println("La luni");
		            	rovinieta[i].setIsExpired(false);
		            	return false;
		            }
		            else 
		            { 
		            	rovinieta[i].setIsExpired(true); 
		            	return true;
		            }
		        }
		        else {
		        	rovinieta[i].setIsExpired(true);
		        	return true;
		        }
			}
		}
		System.out.println("Afara din for");
		return false;
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
			
			this.rovinieta = new Rovinieta[nrRovinieta]; // marit spatiul la 2
			this.rovinieta[nrRovinieta - 2] = temp;      // pe 0 punem temp
			this.rovinieta[nrRovinieta - 1] = rovinieta; // pe 1 punem rovinieta pe care o vrem
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
			nrRovinieta = nrRovinieta -1;
			return true;
		}
		else return false;
	}
	
	
	public String getNrInmatriculare(String serieSasiu) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) )
				return rovinieta[i].getNrInmatriculare();
		}
		return "nimic";
	}

	public String getSerieSasiu(String nrInmatriculare) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( nrInmatriculare.equals( rovinieta[i].getNrInmatriculare() ) )
				return rovinieta[i].getSerieSasiu();
		}
		return "nimic";
	}
	
	public Rovinieta getUltimaRovinieta() 
	{
		if(rovinieta != null)
			return rovinieta[nrRovinieta - 1];
		return null;
	}
};