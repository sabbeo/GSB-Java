package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String Matricule){
		Visiteur unVisiteur;
		unVisiteur = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM visiteur where MATRICULE='"+Matricule+"'");
			if (resultatReq.next()){
				Localite uneLocalite = LocaliteDao.rechercher(resultatReq.getString(7));
				unVisiteur = new Visiteur(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),resultatReq.getString(5),resultatReq.getString(6),uneLocalite,"0780156215",resultatReq.getString(8),0,resultatReq.getString(9),resultatReq.getString(10));

			}
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : SELECT * FROM visiteur where MATRICULE='"+Matricule+"'");  
	} 
	
	return unVisiteur;
	}
	
public static void creer(Visiteur unVisiteur){
		
		String Matricule=unVisiteur.getMatricule();
		String nom=unVisiteur.getNom();
		String prenom=unVisiteur.getPrenom();
		String Login=unVisiteur.getLogin();
		String MDP=unVisiteur.getMdp();
		String Adresse=unVisiteur.getAdresse();
		String CodePostal=unVisiteur.getLocalite().getCodePostal();	
		String Date=unVisiteur.getDateEntree();
		String CodeUnit=unVisiteur.getCodeUnite();
		String NomUnit=unVisiteur.getNomUnite();
		
		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
				ConnexionMySql.execReqMaj("INSERT INTO visiteur VALUES ('"+Matricule+ "','" +nom+ "','" +prenom+ "','" +Login+ "','" +MDP+ "','" +Adresse+ "','" +CodePostal+ "','" +Date+ "','" +CodeUnit+ "','" +NomUnit+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO visiteur VALUES ('"+Matricule+ "','" +nom+ "','" +prenom+ "','" +Login+ "','" +MDP+ "','" +Adresse+ "','" +CodePostal+ "','" +Date+ "','" +CodeUnit+ "','" +NomUnit+ "')");
		}
	}
public static ArrayList<Visiteur> retournerLesVisiteurs() {

	ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
	Localite uneLocalite;
	uneLocalite = null;

	try {
		ResultSet resultatReq = ConnexionMySql.execReqSelection("select * from visiteur");
		while (resultatReq.next()) { // parcours du ResultaSet resultReq
			
			Visiteur unVisiteur = new Visiteur(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),resultatReq.getString(5),resultatReq.getString(6),uneLocalite,"0780156215",resultatReq.getString(8),0,resultatReq.getString(9),resultatReq.getString(10));
			lesVisiteurs.add(unVisiteur);
		}
	} // fin try
	catch (Exception e) {
		System.out.println("Erreur requete : select * from visiteur");
	}
	return lesVisiteurs; 
}
}
