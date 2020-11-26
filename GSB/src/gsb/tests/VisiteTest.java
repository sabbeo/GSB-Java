package gsb.tests;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class VisiteTest {
	public static void main(String[] args) {
	Visite rVisite = VisiteDao.rechercher("v0001");
	AffichageModele.afficher(rVisite);
	
	
	Visiteur unVisiteur = VisiteurDao.rechercher("0V84");
	Medecin UnMedecin = MedecinDao.rechercher("m001");
	Visite uneVisite = new Visite("v0024","02/06/2009 00:00:00","",unVisiteur,UnMedecin);
	VisiteDao.creer(uneVisite);
	
	for(Visite visi : VisiteDao.retournerLesVisites()){
		AffichageModele.afficher(visi);
	}
	
	}
}
