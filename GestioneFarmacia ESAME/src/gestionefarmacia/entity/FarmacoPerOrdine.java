package src.gestionefarmacia.entity;

public class FarmacoPerOrdine {

    // Default constructor

    private int quantita;
    private Farmaco farmaco;
    
    public FarmacoPerOrdine(Farmaco farmaco, int quantita) {
    	this.farmaco = farmaco;
    	this.quantita = quantita;
    }
    
    public void setFarmaco(Farmaco farmaco) {
    	this.farmaco = farmaco;
    }
    
    public Farmaco getFarmaco() {
    	return farmaco;
    }
    
    public String toString() {
		return quantita+" "+farmaco.getNome();
	}
    
    public void setQuantita(int quantita) {
    	this.quantita = quantita;
    }
    
    public int getQuantita() {
    	return quantita;
    }
    
    

}