// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

/************************************************************/
/**
 * 
 */
public class DispVerificare extends Date_Rovinieta {
	/**
	 * 
	 */
	private String idDispVerif;
	/**
	 * 
	 */
	private Rovinieta[] rovinieta;

	public String getIdDispVerif() {
		return idDispVerif;
	}

	public void setIdDispVerif(String idDispVerif) {
		this.idDispVerif = idDispVerif;
	}

	public Rovinieta[] getRovinieta() {
		return rovinieta;
	}

	public void setRovinieta(Rovinieta[] rovinieta) {
		rovinieta = new Rovinieta[rovinieta.length];
		
		for(int i = 0; i < rovinieta.length; ++i)
			this.rovinieta[i] = rovinieta[i];
	}

	public String getSerieSas() {
		return serieSas;
	}

	public void setSerieSas(String serieSas) {
		this.serieSas = serieSas;
	}

	private String serieSas;
	
	/**
	 * 
	 */
	public void alertarePolitie() {
	}

	/**
	 * 
	 */
	public void listaRoviniete() {
	}

	/**
	 * 
	 */
	public void preluareDateRovinieta() {
	}
	
	public void verificareRovinieta(String nrInmatriculare, String serieSasiu, Evidenta evidenta) {
	}
};