package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;
import gsb.utils.AffichageModele;

public class MedecinTest {
	public static void main(String[] args) {
		Localite uneLocalite = new Localite("56800","ploermel");
		Medecin unMedecin = new Medecin ("m021","levare","philipe","rue de la gare",uneLocalite,"06048512","truc","Cardiologie");
		AffichageModele.afficher(unMedecin);
		
		MedecinDao.creer(unMedecin);
		Medecin medc = MedecinDao.rechercher("m001");
		AffichageModele.afficher(medc);
		for(Medecin medc2 : MedecinDao.retournerLesMedecin()){
			AffichageModele.afficher(medc2);
		}
	}
}

