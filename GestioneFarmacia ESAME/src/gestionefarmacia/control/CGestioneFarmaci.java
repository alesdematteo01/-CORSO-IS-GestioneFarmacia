package src.gestionefarmacia.control;

import java.util.ArrayList;
import src.gestionefarmacia.entity.Farmaco;
import src.gestionefarmacia.entity.PrincipioAttivo;
import src.gestionefarmacia.db.DAOException;
import src.gestionefarmacia.db.FarmacoDAO;
import src.gestionefarmacia.db.PrincipioAttivoDAO;;

public class CGestioneFarmaci {

	static ArrayList<Farmaco> lista_farmaci = new ArrayList<Farmaco>();
	static ArrayList<PrincipioAttivo> lista_princ = new ArrayList<PrincipioAttivo>();		
	
	private static CGestioneFarmaci istance = null;
    // Default constructor
    protected CGestioneFarmaci() throws DAOException{
    	lista_farmaci = FarmacoDAO.readAll();
    	lista_princ = PrincipioAttivoDAO.readAll();
    }
    
    public static CGestioneFarmaci Istance() throws DAOException {
    	if(istance == null) {
    		istance = new CGestioneFarmaci();
    	}
    	return istance;
    }

    public void inserisciFarmaco(Farmaco f) {
        lista_farmaci.add(f);
    }

    public void modificaFarmaco(Farmaco f, int qta) {
    	// TODO implement here
    }

    public void cancellaFarmaco(Farmaco f) {
        lista_farmaci.remove(f);
    }

    public void inviaFarmaciMancanti() {
        // TODO implement here
    }
    
    public ArrayList<PrincipioAttivo> getPrincAtt(){
    	return lista_princ;
    }
    
    public ArrayList<Farmaco> getFarmaci(){
    	return lista_farmaci;
    }

}