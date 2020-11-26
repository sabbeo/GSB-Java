package gsb.utils;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class AffichageModele {
	public static void afficher(Localite uneLocalite){
		System.out.println(uneLocalite.getCodePostal());
		System.out.println(uneLocalite.getVille());

	}
	
	public static void afficher(Medecin unMedecin){
		System.out.println(unMedecin.getCodeMed());
		System.out.println(unMedecin.getNom());
		System.out.println(unMedecin.getPrenom());
		System.out.println(unMedecin.getAdresse());
		System.out.println(unMedecin.getLocalite());
		System.out.println(unMedecin.getTelephone());
		System.out.println(unMedecin.getPotentiel());
		System.out.println(unMedecin.getSpecialite());

	}
	public static void afficher(Visiteur unVisiteur){
		System.out.println(unVisiteur.getMatricule());
		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getLogin());
		System.out.println(unVisiteur.getMdp());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getLocalite());
		System.out.println(unVisiteur.getTelephone());
		System.out.println(unVisiteur.getDateEntree());
		System.out.println(unVisiteur.getPrime());
		System.out.println(unVisiteur.getCodeUnite());
	}
	public static void afficher(Medicament unMedicament){
		System.out.println(unMedicament.getDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndication());
		System.out.println(unMedicament.getPrixEchantillon());
		System.out.println(unMedicament.getCodeFamille());
		System.out.println(unMedicament.getLibellefamille());

	}
	public static void afficher(Visite uneVisite){
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDate());
		System.out.println(uneVisite.getCommentaire());
		System.out.println(uneVisite.getUnMedecin());
		System.out.println(uneVisite.getUnVisiteur());
	}
}
