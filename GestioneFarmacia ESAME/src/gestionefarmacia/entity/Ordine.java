package src.gestionefarmacia.entity;

import java.util.ArrayList;

public class Ordine {

    private int id = 0;
    private int ricettaMedica = 0;
    private Stato stato = Stato.PENDENTE;
    private ArrayList<FarmacoPerOrdine> ord_farm = new ArrayList<FarmacoPerOrdine>();
    
    public UtenteRegistrato proprietario;
    

    // Default constructor
    public Ordine(int ricettaMedica, Farmaco[] farmaco, int [] qtaFarmaco) {
    	this.id++;
    	this.ricettaMedica = ricettaMedica;
    	
    	for(int i = 0; i < farmaco.length; i++) {
    		ord_farm.add(new FarmacoPerOrdine(farmaco[i], qtaFarmaco[i]));
    	}
    	
    }
    
    public ArrayList<FarmacoPerOrdine> getFarmaci(){
    	return ord_farm;
    }
    
    public String toString() {
		return "ORDINE EFFETTUATO: "+id+", "+ricettaMedica+", "+ord_farm;
	}
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public Stato getStato() {
    	return stato;
    }
    
    public void setStato(Stato s) {
    	this.stato = s;
    }

    public int getRicettaMedica() {
    	return ricettaMedica;
    }
    
    public void setRicettaMedica(int ricetta) {
    	this.ricettaMedica = ricetta;
    }
    
    public int getId() {
    	return id;
    }
}