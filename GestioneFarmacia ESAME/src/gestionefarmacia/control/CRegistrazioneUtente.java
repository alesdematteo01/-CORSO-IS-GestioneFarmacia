package src.gestionefarmacia.control;

public class CRegistrazioneUtente {

    // Default constructor
	private static CRegistrazioneUtente istance=null;
    protected CRegistrazioneUtente() {
    }
    
    public static CRegistrazioneUtente Istance() {
    	if(istance == null) {
    		istance = new CRegistrazioneUtente();
    	}
    	return istance;
    }

    public void registraUtente() {
        // TODO implement here
    }

}