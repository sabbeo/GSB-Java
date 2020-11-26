package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class VisiteurTest {
	public static void main(String[] args) {
		Localite ploermel = new Localite("56800","ploermel");
		Visiteur bob = new Visiteur("0V84","Dandre","bob","Dbob","egg05","rue de la place",ploermel,"0645815848","02/06/2009 00:00:00",100,"BO","Bourdin");
		AffichageModele.afficher(bob);
		
		VisiteurDao.rechercher("a17");
		VisiteurDao.creer(bob);
		for(Visiteur visi : VisiteurDao.retournerLesVisiteurs()){
			AffichageModele.afficher(visi);
			
		}
		
	}	
}
