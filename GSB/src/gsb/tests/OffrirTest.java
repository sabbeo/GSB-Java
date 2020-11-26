package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;
import gsb.utils.AffichageModele;
import gsb.modele.dao.OffrirDao;

public class OffrirTest {
	public static void main(String[] args) {
		
		Visite rVisite = VisiteDao.rechercher("v0001");
		Medicament medic = MedicamentDao.rechercher("3MYC7");
		
		OffrirDao.give(rVisite,10,medic);
		
	}
}
