// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/************************************************************/
/**
 **
 */
public class Rovinieta {
	
	private static long id = 159001l;

	private long idRovinieta;
	
	private boolean isExpired;

	private String nrInmatriculare;
	
	private String serieSasiu;
	
	private Date data;
	
	/**
	 * Constructor cu parametrii default
	 */
	public Rovinieta()
	{
		idRovinieta = id;
		isExpired = false;
		nrInmatriculare = "";
		serieSasiu = "";
		Rovinieta.id += 1;
	}
	
	/**
	 * Constructori cu parametri introdusi de la tastatura sau direct
	 */
	public Rovinieta(String nrInmat, String serieSasiu)
	{
		idRovinieta = Rovinieta.id;
		nrInmatriculare = nrInmat;
		this.serieSasiu = serieSasiu;
		setData(new Date());
		Rovinieta.id += 1;
	}
	
	public Rovinieta(String nrInmat, String serieSasius, long idRov)
	{
		this.setNrInmatriculare(nrInmat);
		this.setSerieSasiu(serieSasius);
		this.setIdRovinieta(idRov);
		setData(new Date());
	}
	
	/**
	 *	Constructor de copiere 
	 */
	public Rovinieta(Rovinieta rov)
	{
		this(rov.nrInmatriculare, rov.serieSasiu, rov.getIdRovinieta());
		this.setData(rov.getData());
	}
	
	/**
	 * Setteri si getteri pentru fiecare atribut in parte
	 */
	public String getNrInmatriculare() {
		return nrInmatriculare;
	}
	
	public Date getData() 
	{
		return this.data;
	}
	
	/**
	 * Modalitate de setare a datei Rovinietei
	 * @param data - data noua a Rovinietei
	 */
	public void setData(Date data)
	{
		this.data = data;
		
		Date date = getData();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if(Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) {
			if(((Calendar.getInstance().get(Calendar.MONTH)) + 1) - (cal.get(Calendar.MONTH) + 1) < 6)
				this.setIsExpired(false);
			else this.setIsExpired(true);
		}
		else this.setIsExpired(true);
	}

	public void setNrInmatriculare(String nrInmatriculare) {
		this.nrInmatriculare = nrInmatriculare;
	}

	public long getIdRovinieta() {
		return idRovinieta;
	}

	public void setIdRovinieta(long idRovinieta) {
		this.idRovinieta = idRovinieta;
	}

	public boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
	public String getSerieSasiu() {
		return this.serieSasiu;
	}
	
	public void setSerieSasiu(String serieSasiu) {
		this.serieSasiu = serieSasiu;
	}
	
	/**
	 * Metoda folosita pentru a returna datele din rovinieta si specificarea starii acesteia(expirata sau nu)
	 */
	public void afisareDate() 
	{
		System.out.println("Rovinieta ID: " + this.idRovinieta);
		System.out.println("Numar inmatriculare: " + this.nrInmatriculare);
		System.out.println("Serie sasiu: " + this.serieSasiu);
		System.out.println("Data: " + this.data);
		System.out.print("Expirata: ");
		if(getIsExpired() == true)
			System.out.println("Da");
		else System.out.println("Nu");
	}

};
