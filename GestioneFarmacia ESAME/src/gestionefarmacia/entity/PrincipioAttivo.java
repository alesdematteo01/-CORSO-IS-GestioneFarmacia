package src.gestionefarmacia.entity;

public class PrincipioAttivo {

    private String nome;
    private int codice;
    private int quantitaResidua;
    private String tipo;
    
    // Default constructor
    public PrincipioAttivo(int codice, String nome, int quantitaResidua, String tipo) {
    	this.nome = nome;
    	this.codice = codice;
    	this.quantitaResidua = quantitaResidua;
    	this.tipo = tipo;
    }

    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String toString() {
		return nome;
	}
    
    public int getCodice() {
    	return codice;
    }
    
    public void setCodice(int codice) {
    	this.codice = codice;
    }
    
    public int getQuantitaResidua() {
    	return quantitaResidua;
    }
    
    public void setQuantitaResidua(int quantitaResidua) {
    	this.quantitaResidua = quantitaResidua;
    }
    
    public String getTipo() {
    	return tipo;
    }

}