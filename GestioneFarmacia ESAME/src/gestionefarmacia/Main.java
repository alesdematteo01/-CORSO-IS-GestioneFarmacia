package src.gestionefarmacia;

import src.gestionefarmacia.control.*;
import src.gestionefarmacia.db.DAOException;
import src.gestionefarmacia.entity.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		
		CGestioneFarmaci gestioneFarmaci = null;
		
		try {
			gestioneFarmaci = CGestioneFarmaci.Istance();
		}
		catch(DAOException e){
			
			System.out.println("ERRORE: Impossibile accedere al database.\n");
			e.printStackTrace();
			System.exit(1);
		}
		
		CGestioneAcquisti gestioneAcquisti = CGestioneAcquisti.Istance();
		
		
		ArrayList<PrincipioAttivo> pa_list = gestioneFarmaci.getPrincAtt();
		ArrayList<Farmaco> f_list = gestioneFarmaci.getFarmaci();
				
		PrincipioAttivo pa1 = pa_list.get(0);
		Farmaco f1 = f_list.get(1);
		f1.addPrincipioAttivo(pa1);
		
		PrincipioAttivo pa2 = pa_list.get(1);
		Farmaco f2 = f_list.get(0);
		f2.addPrincipioAttivo(pa2);
		f1.addPrincipioAttivo(pa2);
		
		Farmaco f3 = f_list.get(2);
		f3.addPrincipioAttivo(pa1);
		
		PrincipioAttivo pa3 = pa_list.get(2);
		f1.addPrincipioAttivo(pa3);
		
		PrincipioAttivo pa4 = pa_list.get(3);
		Farmaco f4 = f_list.get(3);
		f4.addPrincipioAttivo(pa4);
		
		System.out.println("\nQuesti sono i farmaci presenti nel database:");
		System.out.println(f_list+"\n");
		
		ArrayList<Farmaco> f_disponibili = gestioneAcquisti.visualizzaCatalogo();
		
		System.out.println("Questi sono i farmaci disponibili:\n");

		for(Farmaco f: f_disponibili) {
			System.out.println(f+ "\n");
		}
		
		int ricetta = 1234;
		Farmaco[] acquisti = {f2, f3};
		int [] quantita_acquisti = {4, 7};
		Ordine o;
		try {
			o = gestioneAcquisti.acquistaFarmaci(ricetta, acquisti, quantita_acquisti);
			System.out.println(o + "\n");
		} catch (DAOException e) {
			System.out.println("ERRORE: Impossibile effettuare l'ordine.\n");
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Questi sono i farmaci nel DB dopo l'ordine effettuato.");
		System.out.println(f_list);
	}

}
