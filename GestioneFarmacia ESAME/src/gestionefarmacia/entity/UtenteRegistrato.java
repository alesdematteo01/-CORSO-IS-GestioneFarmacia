package src.gestionefarmacia.entity;

import java.util.*;

public class UtenteRegistrato {

    // Default constructor

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String codiceFiscale;
    private String tesseraSanitaria;
    private String cartaCredito;
    
    public UtenteRegistrato(String nome, String cognome, Date dataNascita, String codiceFiscale, String tesseraSanitaria, String cartaCredito) {
    	this.nome = nome;
    	this.cognome = cognome;
    	this.dataNascita = dataNascita;
    	this.codiceFiscale = codiceFiscale;
    	this.tesseraSanitaria = tesseraSanitaria;
    	this.cartaCredito = cartaCredito;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public String getCognome() {
    	return cognome;
    }
    
    public Date getDataNascita() {
    	return dataNascita;
    }
    
    public String getCodiceFiscale() {
    	return codiceFiscale;
    }
    
    public String getTesseraSanitaria() {
    	return tesseraSanitaria;
    }
    
    public String getCartaCredito() {
    	return cartaCredito;
    }

}