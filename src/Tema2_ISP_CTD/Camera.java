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
	
	
	Camera(String idCamera){
		this.idCamera = idCamera;
		stareCam = StariCamera.Pornita;
		
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
	
	
	/**
	 * transmitereDate = getter pt nrInmatriculare
	 * 
	 */
	
	public String transmitereDate() {
		
		
		stareCam = StariCamera.DateTransmise;
		return nrInmatriculare;
	}


	/**
	 * 
	 */
	public void identificareNrMasina() {
		if(img.getNrMasina() != null) {
			this.nrInmatriculare = img.getNrMasina();
			stareCam = StariCamera.NrIdentificat;
			return true;
		
		}
		return false;
	}

	/**
	 * 
	 */
	public void capturareImagine() {
		stareCam = StariCamera.ImagineCapturata;
		this.img = imagine;
	}
};
