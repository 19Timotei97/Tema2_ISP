package Tema2_ISP_CTD;

public class Imagine {
	private String nrMasina;

    Imagine(String nrImatriculare){
        this.nrMasina = nrMasina;

    }
    Imagine(){
        nrMasina = null;
    }

    public String getNrMasina() {
        return nrMasina;
    }

    public void setNrMasina(String nrMasina) {
        this.nrMasina = nrMasina;
    }

}
