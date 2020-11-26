package gsb.tests;

import gsb.utils.AffichageModele;
import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteTest {
	public static void main(String[] args) {

		Localite uneLocalite = new Localite("56800","ploermel");
		AffichageModele.afficher(uneLocalite);
		
		LocaliteDao.creer(uneLocalite);
		
		Localite loca = LocaliteDao.rechercher("13012");
		AffichageModele.afficher(loca);
		
		for(Localite loca2 : LocaliteDao.retournerLesLocalite()){
			AffichageModele.afficher(loca2);
		}
	}
}