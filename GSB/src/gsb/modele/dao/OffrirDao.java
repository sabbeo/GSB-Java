package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;;

public class OffrirDao {

	public static void give(Visite uneVisite,int QTE,Medicament unMedicament){
		//uneVisite.getUnVisiteur().
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ConnexionMySql.execReqMaj("INSERT INTO offrir VALUES ('"+uneVisite.getReference()+ "','" +QTE+ "','" +unMedicament.getDepotLegal()+ "')");
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : INSERT INTO offrir VALUES ('"+uneVisite.getReference()+ "','" +QTE+ "','" +unMedicament.getDepotLegal()+ "')");
	}
		
		Stocker unStock = StockerDao.rechercher(unMedicament,uneVisite.getUnVisiteur());
		
		int StockQTE = unStock.getQteStock()+ QTE;
		
		
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ConnexionMySql.execReqMaj("update stocker set QTE = '"+StockQTE+"' where visiteur = '"+uneVisite.getUnVisiteur().getMatricule()+"' and medicament = '"+unMedicament.getDepotLegal()+"' ");
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : INSERT INTO stocker VALUES ('"+uneVisite.getReference()+ "','" +QTE+ "','" +unMedicament.getDepotLegal()+ "')");
	}
		
	}
	
	
	
}
	

