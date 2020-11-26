package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medecin;;

public class MedecinDao {
	public static Medecin rechercher(String codeMed){
		Medecin unMedecin;
		unMedecin = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM medecin where CODEMED='"+codeMed+"'");
			if (resultatReq.next()){
				Localite uneLocalite = LocaliteDao.rechercher(resultatReq.getString(5));
				unMedecin = new Medecin(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),uneLocalite,resultatReq.getString(6),resultatReq.getString(7),resultatReq.getString(8));

			}
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : SELECT * FROM medecin where CODEMED='"+codeMed+"'");  
	} 
	
	return unMedecin;
	}
	
public static void creer(Medecin unMedecin){
		
		String Code=unMedecin.getCodeMed();
		String nom=unMedecin.getNom();
		String prenom=unMedecin.getPrenom();
		String adresse=unMedecin.getAdresse();
		String tel=unMedecin.getTelephone();
		String potentiel=unMedecin.getPotentiel();
		String specialite=unMedecin.getSpecialite();												
		String CodePostal=unMedecin.getLocalite().getCodePostal();

		
		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
				ConnexionMySql.execReqMaj("INSERT INTO medecin VALUES ('"+Code+ "','" +nom+ "','" +prenom+ "','" +adresse+ "','" +CodePostal+ "','" +tel+ "','" +potentiel+ "','" +specialite+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO medecin VALUES ('"+Code+ "','" +nom+ "','" +prenom+ "','" +adresse+ "','" +CodePostal+ "','" +tel+ "','" +potentiel+ "','" +specialite+ "')");
		}
	}

public static ArrayList<Medecin> retournerLesMedecin() {

	ArrayList<Medecin> lesMedecin = new ArrayList<Medecin>();
	Localite uneLocalite;
	uneLocalite = null;

	try {
		ResultSet resultatReq = ConnexionMySql.execReqSelection("select * from medecin");
		while (resultatReq.next()) { // parcours du ResultaSet resultReq
			
			Medecin unMedecin = new Medecin(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),uneLocalite,resultatReq.getString(6),resultatReq.getString(7),resultatReq.getString(8));
			lesMedecin.add(unMedecin);
		}
	} // fin try
	catch (Exception e) {
		System.out.println("Erreur requete : select * from medecin");
	}
	return lesMedecin; 
}
}
