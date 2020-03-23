package src.gestionefarmacia.control;

import java.util.ArrayList;

import src.gestionefarmacia.db.DAOException;
import src.gestionefarmacia.db.FarmacoDAO;
import src.gestionefarmacia.entity.Farmaco;
import src.gestionefarmacia.entity.Ordine;
import src.gestionefarmacia.entity.Stato;

public class CGestioneAcquisti {

	ArrayList<Farmaco> lista_farmaci_disponibili;

	private static CGestioneAcquisti istance = null;
    protected CGestioneAcquisti() {
    	lista_farmaci_disponibili = new ArrayList<Farmaco>();
    }
    
    public static CGestioneAcquisti Istance() {
    	if(istance == null) {
    		istance = new CGestioneAcquisti();
    	}
    	return istance;
    }

    public ArrayList<Farmaco> visualizzaCatalogo() {
    	
    	for (Farmaco f : CGestioneFarmaci.lista_farmaci) {
    		if(f.getQuantita() > 0) {
    			lista_farmaci_disponibili.add(f);
    		}
    	}
        return lista_farmaci_disponibili;   
        }
    


    public Ordine acquistaFarmaci(int ricetta, Farmaco[] farmaco, int [] qtaFarmaco) throws DAOException {
    	for(int h = 0; h < farmaco.length; h++) {
    		if(ricetta == 0 && farmaco[h].getPrescrivibile() == true) {
    			System.out.println("Impossibile effettuare l'ordine.");
    			System.exit(1);
    		}
    	}
    	for(int r = 0; r < farmaco.length; r++) {
    		if(farmaco[r].getQuantita() < qtaFarmaco[r]) {
    			System.out.println("Impossibile effettuare l'ordine.");
    			System.exit(1);
    		}
    	}
    	Ordine o = new Ordine(ricetta, farmaco, qtaFarmaco);
    	autorizzaAcquisto(o);
    	int differenza, qtaMagazzino; 
    	for(int j = 0; j < farmaco.length; j++ ) {
    		qtaMagazzino = farmaco[j].getQuantita(); 
    		differenza = qtaMagazzino - qtaFarmaco[j];
    		farmaco[j].setQuantita(differenza);
    		FarmacoDAO.update(farmaco[j]);
    	}
    	return o;
    }

    public void autorizzaAcquisto(Ordine o) {
        o.setStato(Stato.AUTORIZZATO);
    }

    public void generaReport() {
        // TODO implement here
    }

}