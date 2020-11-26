package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.Localite;

public class LocaliteDao {
	public static Localite rechercher(String codePostal){
		Localite uneLocalite;
		uneLocalite = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM localite where codePostal='"+codePostal+"'");
			if (resultatReq.next()){
				uneLocalite = new Localite(resultatReq.getString(1),resultatReq.getString(2));

			}
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : SELECT * FROM localite where codePostal='"+codePostal+"'");  
	} 
	
	return uneLocalite;
	}
	
	public static void creer(Localite uneLocalite){
		
		String Code=uneLocalite.getCodePostal() ;
		String Ville=uneLocalite.getVille();


		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
				ConnexionMySql.execReqMaj("INSERT INTO localite VALUES ('"+Code+ "','" +Ville+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO localite VALUES ('"+Code+ "','" +Ville+ "')");  
		}
	}
	public static ArrayList<Localite> retournerLesLocalite() {

			ArrayList<Localite> lesLocalite = new ArrayList<Localite>();
	 
			try {
				ResultSet resultatReq = ConnexionMySql.execReqSelection("select * from localite");
				while (resultatReq.next()) { // parcours du ResultaSet resultReq
					Localite uneLocalite = new Localite(resultatReq.getString(1), resultatReq.getString(2));
					lesLocalite.add(uneLocalite);
				}
			} // fin try
			catch (Exception e) {
				System.out.println("Erreur requete : select * from codePostal");
			}
			return lesLocalite; 
		}		
	}	