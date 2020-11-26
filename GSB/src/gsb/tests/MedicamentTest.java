package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.utils.AffichageModele;

public class MedicamentTest {
	public static void main(String[] args) {
		Medicament unMedicament = new Medicament("H02AB10","Cortisol","corticost�ro�de","Effets anti-inflammatoires","Ce m�dicament est contre-indiqu� en cas d allergie...",0,"AI","anti-inflammatoires");
		AffichageModele.afficher(unMedicament);
		
		MedicamentDao.creer(unMedicament);
		
		Medicament medic = MedicamentDao.rechercher("ADIMOL9");
		AffichageModele.afficher(medic);
		
		for(Medicament loca2 : MedicamentDao.retournerlesMedicaments()){
			AffichageModele.afficher(loca2);
		
		}
	
	}
}
