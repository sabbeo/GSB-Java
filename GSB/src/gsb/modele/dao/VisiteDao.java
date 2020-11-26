package gsb.modele.dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {
	public static Visite rechercher(String REFERENCE){
		Visite uneVisite;
		uneVisite = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM visite where REFERENCE='"+REFERENCE+"'");
			if (resultatReq.next()){
				Visiteur visiteur = VisiteurDao.rechercher(resultatReq.getString(4));
				Medecin medecin = MedecinDao.rechercher(resultatReq.getString(5));
				uneVisite = new Visite(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),visiteur,medecin);

			}
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : SELECT * FROM visite where REFERENCE='"+REFERENCE+"'");  
	} 
	
	return uneVisite;
}
	
public static void creer(Visite uneVisite){
		
		String Ref=uneVisite.getReference();
		String Date=uneVisite.getDate();
		String Com=uneVisite.getCommentaire();
		String Visiteur=uneVisite.getUnVisiteur().getMatricule();
		String Medecin=uneVisite.getUnMedecin().getCodeMed();


		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
				ConnexionMySql.execReqMaj("INSERT INTO visite VALUES ('"+Ref+ "','" +Date+ "','" +Com+ "','" +Visiteur+ "','" +Medecin+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO visite VALUES ('"+Ref+ "','" +Date+ "','" +Com+ "','" +Visiteur+ "','" +Medecin+ "')");
		}
	}
public static ArrayList<Visite> retournerLesVisites() {

	ArrayList<Visite> lesVisites = new ArrayList<Visite>();

	try {
		ResultSet resultatReq = ConnexionMySql.execReqSelection("select * from visite");
		while (resultatReq.next()) { // parcours du ResultaSet resultReq
			Visiteur visiteur = VisiteurDao.rechercher(resultatReq.getString(4));
			Medecin medecin = MedecinDao.rechercher(resultatReq.getString(5));
			Visite uneVisite = new Visite(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),visiteur,medecin);
			lesVisites.add(uneVisite);
		}
	} // fin try
	catch (Exception e) {
		System.out.println("Erreur requete : select * from visiteur");
	}
	return lesVisites; 
}
}
