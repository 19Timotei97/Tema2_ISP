// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema2_ISP_CTD;

/************************************************************/
/**
 * 
 */
public class Camera {
	/**
	 * 
	 */
	private String idCamera;
	/**
	 * 
	 */
	private String nrInmatriculare;
	/**
	 * 
	 */
	private StariCamera StareCam;
	
	/**
	 * 
	 */
	private Imagine img;
	
	
	public Camera(String idCamera){
		this.idCamera = idCamera;
		StareCam = StariCamera.Pornita;
		
	}

	public String getIdCamera() {
		return idCamera;
	}

	public void setIdCamera(String idCamera) {
		this.idCamera = idCamera;
	}

	
	public void setNrInmatriculare(String nrInmatriculare) {
		this.nrInmatriculare = nrInmatriculare;
	}

	public StariCamera getStareCam() {
		return StareCam;
	}

	public void setStareCam(StariCamera stareCam) {
		StareCam = stareCam;
	}
	
	public String getNrInmatriculare() {
		StareCam = StariCamera.DateTransmise;
		return nrInmatriculare;
	}


	/**
	 * 
	 */
	public boolean identificareNrMasina() {
	String nrMasina = img.getNrMasina();
	if(nrMasina != null && !nrMasina.equals("") && !nrMasina.equals(" ")) {
		this.nrInmatriculare = nrMasina;
		StareCam = StariCamera.NrIdentificat;
		System.out.println("Cofirmare existenta date!");
		return true;
	}
	System.out.println("Nu sunt date disponibile!");
	return false;
	}

	/**
	 * 
	 */
	public void capturareImagine(Imagine imag) {
		StareCam = StariCamera.ImagineCapturata;
		this.img = imag;
	}
};
