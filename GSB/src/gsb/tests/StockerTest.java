package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteDao;

public class StockerTest {
	public static void main(String[] args) {
		
		//Visite rVisite = VisiteDao.rechercher("v0001");
		//Medicament medic = MedicamentDao.rechercher("3MYC7");
		
		ArrayList<Stocker> lesStock = null;
		lesStock = StockerDao.ListeMedicament("a131");
		for(Stocker unStock : lesStock){
			System.out.println(unStock.getUnMedicament().getDepotLegal());  
		}
		
		//Stocker unStock = StockerDao.rechercher(, unVisiteur)
	}
}
