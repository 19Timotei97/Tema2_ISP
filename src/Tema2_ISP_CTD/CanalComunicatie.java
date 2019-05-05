package Tema2_ISP_CTD;

public class CanalComunicatie {
	Camera cam;
	
	public CanalComunicatie(Camera cam1) {
		this.cam = cam1;
	}
	
	public CanalComunicatie() {
		this.cam = null;
	}	
	
	
	/**
	 * Verific daca s a connectat camera la Canalul de comunicatie
	 * 
	 * Nu modificati tipul de return, metoda este folosita pentru teste
	 * @return
	 */
	public boolean verificareConnectareCamera() {
		if(this.cam != null) {
			System.out.println("Camera a creat canalul de comunicatie");
			return true;
		}
		System.out.println("EROARE: Canal de Comunicatie inexistent! ");
		return false;
	}
	
	/**
	 * Transmit date de la canalul de comunicatie, apoi sunt preluate in metoda acceptareDate() 
	 * din clasa  DispVerificare
	 * @return
	 */
	public String transmitereDate() {
		
		if(this.cam != null) {
			String date = cam.getNrInmatriculare();
			return date;
		}
		
		return null;	
	}
}