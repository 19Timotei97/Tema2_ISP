// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/************************************************************/
/**
 * 
 */
public class Organ_politie extends Date_Rovinieta {
	/**
	 * 
	 */
	private String nume;

	/**
	 * 
	 */
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	/**
	 *  Fac override la fct verificareRovinieta din cls Date_Rovinieta 
	 */
	
	@Override 
	
	public boolean verificareRovinieta(long id) {
		if(super.verificareRovinieta(id) == false) {
			 this.aplicareSanctiune();
			 return false;
		}
		return true;
		
		
		
	}
	/*
	 * 
	 */
	
	public void aplicareSanctiune() {
		
		String proba = "Rovinieta expirata";
		
		String loc = "DN2";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		
		String data = dateFormat.format(cal.getTime()).toString();
		
		
		/**
		 * Ba, am scos campul ora din sanctiune, ca oricum o sa fie in data
		 * 
		 * !Vezi  ca obiectul meu "sanctiune" sa l apeleze ok.
		 * 
		 */
		return new Sanctiune(proba, data, loc, this);
		
	}
};
