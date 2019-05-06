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
	
	/**
	 * Returneaza vectorul de roviniete
	 */
	public Rovinieta[] getRovinieta() {
		return this.rovinieta;
	}

	/**
	 * Intoarce rovinieta de pe pozitia data ca parametru
	 * @param i - pozitia rovinietei care se doreste a fi returnata
	 */
	public Rovinieta getRovinieta(int i) {
		return this.rovinieta[i];
	}
	
	/**
	 * Seteaza vectorul de roviniete cu un vector dat ca parametru
	 * @param rovinieta
	 * @param lungime
	 */
	public void setRovinieta(Rovinieta[] rovinieta, int lungime) {
		this.rovinieta = new Rovinieta[lungime];
		nrRovinieta =0;
		
		for(int i=0; i<lungime; ++i) {
			this.rovinieta[i] = rovinieta[i];
			nrRovinieta = nrRovinieta +1;
		}
	}
	
	/**
	 * Seteaza rovinietea de pe pozitia data ca parametru cu rovinieta rov
	 * @param rov - noua rovinieta ce va fi setata
	 * @param poz - pozitia pe care se va pune noua rovinieta
	 */
	public void setRovinieta(Rovinieta rov, int poz) {
		if(rovinieta != null)
		this.rovinieta[poz] = rov;
	}
	
	/**
	 * Seteaza nr de roviniete si aloca spatiu daca este necesar
	 * @param nr
	 */
	public void setNrRoviniete(int nr) {
		if(nrRovinieta == 0) rovinieta = new Rovinieta[nr];
		this.nrRovinieta = nr;
	}
	
	public int getNrRoviniete() {
		return nrRovinieta;
	}
	
	/**
	 * Posibilitatea schimbarii datei unei Roviniete
	 * @param date - data cu care se va schimba data originala
	 * @param i - pozitia ocupata de Rovinieta in vectorul de roviniete
	 * Se verifica si daca rovinieta este cu noua data expirata sau nu
	 */
	public void schimbaData(Date date, int i)
	{
		if(rovinieta != null)
			rovinieta[i].setData(date);
		
		Date data = rovinieta[i].getData();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		if(Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
			if(((Calendar.getInstance().get(Calendar.MONTH)) + 1) - (cal.get(Calendar.MONTH) + 1) < 6)
				rovinieta[i].setIsExpired(false);
			else rovinieta[i].setIsExpired(true);
		}
		else rovinieta[i].setIsExpired(true);
	}
	
	/**
	 * Metoda ce afiseaza fiecare rovinieta din vectorul de roviniete
	 */
	public void afiseazaRoviniete() 
	{
		if(rovinieta != null && nrRovinieta > 0)
			for(int i=0; i<nrRovinieta; ++i)
				rovinieta[i].afisareDate();
	}
	
	
	
	/**
	 * Metoda folosita pentru a verifica existenta unei roviniete in evidenta
	 * Se utilizeaza seria sasiului automobilului pentru care este inregistrata rovinieta
	 * sau nr de inmatriculare iar in optiune se trece fie "sasiu" fie "inmatr", in functie de preferinta.
	 * @param str - seria sasiului sau nr de inmatriculare, depinzand de cazul de folosinta 
	 * @param optiune - sasiu / inmatr, fiind optiunea dupa care se verifica existenta
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
	
	/**
	 * Metoda folosita pentru a verifica valabilitatea rovinietei in functie de seria sasiului
	 * @param seriaSasiu - seria sasiului coresp. rovinietei
	 */
	public boolean rovinietaExpirata(String serieSasiu) {
		
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) ) {
				
				Date date = rovinieta[i].getData();
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(date);

		        if(Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
		        	if(((Calendar.getInstance().get(Calendar.MONTH)) + 1) - (cal.get(Calendar.MONTH) + 1) < 6) {
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
		return false;
	}
	
	/**
	 * Posibilitatea adaugarii de rovinieta in vectorul de roviniete
	 * Exista 3 cazuri:
	 * 
	 * 1. In cazul in care exista mai mult de o rovinieta, se realoca spatiu pentru vectorul de roviniete si se salveaza intr-un vector temporar
	 * vechile roviniete. Apoi se vor recopia in vectorul original valorile din vectorul temporar.
	 * 
	 * 2. Daca exista o singura rovinieta in vectorul de roviniete, se salveaza rovinieta existenta intr-o variabila temporara, se realoca spatiu cu unul mai mult
	 * si apoi se pun in vectorul original rovinieta veche si cea noua.
	 * 
	 * 3. Daca nu exista nicio rovinieta, se aloca spatiu initial si se pune pe prima pozitie rovinieta dorita
	 */
	public void adaugaRovinieta(Rovinieta rovinieta) {
		
		if(nrRovinieta > 1) {
			//nrRov = 2 sau mai mare
			nrRovinieta = nrRovinieta +1;
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
		else if(nrRovinieta == 0){
			nrRovinieta = nrRovinieta +1;
			this.rovinieta = new Rovinieta[nrRovinieta]; // aloc 1 spatiu
			this.rovinieta[nrRovinieta-1] = rovinieta;   // pun pe pozitia 1-1=0 pe rovinieta
		} 
		
	}
	
	/**
	 * Metoda ce va fi folosita daca se doreste scoaterea din Evidenta a unei roviniete
	 * @param rovinieta - rovinieta care se doreste a fi scoasa 
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
			nrRovinieta = nrRovinieta - 1;
			return true;
		}
		else return false;
	}
	
	/**
	 * Returneaza numarul de inmatriculare in functie de seria sasiului data ca parametru
	 */
	public String getNrInmatriculare(String serieSasiu) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( serieSasiu.equals( rovinieta[i].getSerieSasiu() ) )
				return rovinieta[i].getNrInmatriculare();
		}
		return "nimic";
	}

	/**
	 * Returneaza seria sasiului in functie de nr de inmatriculare dat ca parametru
	 */
	public String getSerieSasiu(String nrInmatriculare) {
		for(int i=0; i<nrRovinieta; ++i) {
			if( nrInmatriculare.equals( rovinieta[i].getNrInmatriculare() ) )
				return rovinieta[i].getSerieSasiu();
		}
		return "nimic";
	}
	
	/**
	 *	Returneaza ultima rovinieta din vectorul de roviniete din evidenta 
	 */
	public Rovinieta getUltimaRovinieta() 
	{
		if(rovinieta != null)
			return rovinieta[rovinieta.length - 1];
		return null;
	}
};
