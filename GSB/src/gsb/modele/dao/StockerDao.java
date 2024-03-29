package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class StockerDao {

public static void creer(Medicament unMedicament,Visiteur unvisiteur,int QTE){
		
		String depot=unMedicament.getDepotLegal();
		String id=unvisiteur.getMatricule();
		
		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions � la base
				ConnexionMySql.execReqMaj("INSERT INTO stocker VALUES ('"+id+ "','" +depot+ "','" +QTE+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO stocker VALUES ('"+id+ "','" +depot+ "','" +QTE+ "')");
		}
	}
public static Stocker rechercher(Medicament unMedicament,Visiteur unVisiteur){
	
		Stocker enStock;
		enStock = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions � la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM stocker where medicament='"+unMedicament.getDepotLegal()+"' and visiteur = '"+unVisiteur.getMatricule()+"'");
			if (resultatReq.next()){
				Visiteur visiteur = VisiteurDao.rechercher(resultatReq.getString(2));
				Medicament unMed = MedicamentDao.rechercher(resultatReq.getString(1));
				enStock = new Stocker(resultatReq.getInt(3),visiteur,unMed);

			}
		} // fin try
			catch(Exception e) {  
				e.printStackTrace();
				System.out.println("Erreur requete : SELECT * FROM localite where codePostal='"+unMedicament.getDepotLegal()+"'");  
			} 

return enStock;
}
public static ArrayList<Stocker> ListeMedicament(String code){
	
	ArrayList<Stocker> lesStock = new ArrayList<Stocker>();

	try {
		// Statement : C'est une classe que l'application  emploie pour transmettre des instructions � la base
		ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM stocker where visiteur = '"+code+"'");
		while (resultatReq.next()){
			Visiteur visiteur = VisiteurDao.rechercher(resultatReq.getString(1));
			Medicament unMed = MedicamentDao.rechercher(resultatReq.getString(2));
			Stocker unStock = new Stocker(resultatReq.getInt(3),visiteur,unMed);
			lesStock.add(unStock);

		}
	} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : SELECT * FROM localite where codePostal='"+code+"'");  
		} 

return lesStock;
}
	@SuppressWarnings("unused")
	public static int Ajout(Visiteur unVisiteur,Medicament unMedicament,int QTE){

		Stocker unStock = StockerDao.rechercher(unMedicament,unVisiteur);
		int retoure = 0;
		
		
		if (unStock !=null){
			try {
				
				System.out.println("update stocker set QTE = '"+QTE+"' where visiteur = '"+unVisiteur.getMatricule()+"' and medicament = '"+unMedicament.getDepotLegal()+"' ");
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions � la base
				int StockQTE = unStock.getQteStock()+ QTE;
				retoure = ConnexionMySql.execReqMaj("update stocker set QTE = '"+StockQTE+"' where visiteur = '"+unVisiteur.getMatricule()+"' and medicament = '"+unMedicament.getDepotLegal()+"' ");
				
			}
			catch(Exception e) {  
				e.printStackTrace();
				System.out.println("Erreur requete : INSERT INTO stocker VALUES ('"+unVisiteur.getMatricule()+ "','" +unMedicament.getDepotLegal()+ "','" +QTE+ "')");
			}
		}
		else{
			try {
				System.out.println("insert into stocker '"+unVisiteur.getMatricule() +"','"+unMedicament.getDepotLegal()+"','" +QTE+ "')");

				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions � la base
					retoure = ConnexionMySql.execReqMaj("insert into stocker VALUES('"+unVisiteur.getMatricule() +"','"+unMedicament.getDepotLegal()+"','" +QTE+ "')");
					
				}
			
				catch(Exception e) {  
					e.printStackTrace();
					System.out.println("Erreur requete : INSERT INTO stocker VALUES ('"+unVisiteur.getMatricule()+ "','" +unMedicament.getDepotLegal()+ "','" +QTE+ "')");
				}
			}
		return retoure;
	}
}
