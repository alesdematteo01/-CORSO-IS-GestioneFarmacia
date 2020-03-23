package src.gestionefarmacia.entity;

import java.util.ArrayList;

public class Farmaco {
    
	private int codice;
    private String nome;
    private float prezzo;
    private int quantita;
    private boolean prescrivibile;
    private Produzione produzione;
    private ArrayList<PrincipioAttivo> princAttivo = new ArrayList<PrincipioAttivo>();
    
    // Default constructor
    public Farmaco(int codice, String nome, float prezzo, int quantita, boolean prescrivibile, Produzione produzione) {
    	this.codice = codice;
    	this.nome = nome;
    	this.prezzo = prezzo;
    	this.quantita = quantita;
    	this.prescrivibile = prescrivibile;
    	this.produzione = produzione;
    	
    }

	public void addPrincipioAttivo(PrincipioAttivo pA) {
		princAttivo.add(pA);
	}
	
	public String toString() {
		return "FARMACO: "+codice+", "+nome+", "+prezzo+", "+quantita+", "+princAttivo;
	}
	
	public ArrayList<PrincipioAttivo> getPrincipiAttivi(){
		return princAttivo;
	} 

    public int getCodice() {
        return codice;
    }
    
    public void setCodice(int codice) {
    	this.codice = codice;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public float getPrezzo() {
    	return prezzo;
    }
    
    public int getQuantita() {
        return quantita;
    }
    
    public void setQuantita(int quantita) {
    	this.quantita = quantita;
    }

    public boolean getPrescrivibile() {
    	return prescrivibile;
    }
    
    public Produzione getProduzione() {
    	return produzione;
    }

}