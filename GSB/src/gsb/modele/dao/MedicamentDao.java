package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import gsb.modele.Medicament;


public class MedicamentDao {
	public static Medicament rechercher(String Code){
		Medicament unMedicament;
		unMedicament = null;
		try {
			// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
			ResultSet resultatReq =ConnexionMySql.execReqSelection("SELECT * FROM medicament where MED_DEPOTLEGAL='"+Code+"'");
			if (resultatReq.next()){
				unMedicament = new Medicament(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),resultatReq.getString(5),resultatReq.getFloat(6),resultatReq.getString(7),resultatReq.getString(8));

			}
	} // fin try
	catch(Exception e) {  
		e.printStackTrace();
		System.out.println("Erreur requete : SELECT * FROM medicament where MED_DEPOTLEGAL='"+Code+"'");  
	} 
	
	return unMedicament;
	}
	
public static void creer(Medicament unMedicament){
		
		String depot=unMedicament.getDepotLegal();
		String nom=unMedicament.getNomCommercial();
		String Composition=unMedicament.getComposition();
		String Effets=unMedicament.getEffets();
		String ContreIndication=unMedicament.getContreIndication();
		float Prix=unMedicament.getPrixEchantillon();
		String Code=unMedicament.getCodeFamille();								
		String Libelle=unMedicament.getLibellefamille();

		
		try {
				// Statement : C'est une classe que l'application  emploie pour transmettre des instructions à la base
				ConnexionMySql.execReqMaj("INSERT INTO medicament VALUES ('"+depot+ "','" +nom+ "','" +Composition+ "','" +Effets+ "','" +ContreIndication+ "','" +Prix+ "','" +Code+ "','" +Libelle+ "')");
		} // fin try
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Erreur requete : INSERT INTO medicament VALUES ('"+depot+ "','" +nom+ "','" +Composition+ "','" +Effets+ "','" +ContreIndication+ "','" +Prix+ "','" +Code+ "','" +Libelle+ "')");
		}
	}
public static ArrayList<Medicament> retournerlesMedicaments() {

	ArrayList<Medicament> lesMedicaments = new ArrayList<Medicament>();

	try {
		ResultSet resultatReq = ConnexionMySql.execReqSelection("select * from medicament");
		while (resultatReq.next()) { // parcours du ResultaSet resultReq
			
			Medicament unMedicament = new Medicament(resultatReq.getString(1),resultatReq.getString(2),resultatReq.getString(3),resultatReq.getString(4),resultatReq.getString(5),resultatReq.getFloat(6),resultatReq.getString(7),resultatReq.getString(8));
			lesMedicaments.add(unMedicament);
		}
	} // fin try
	catch (Exception e) {
		System.out.println("Erreur requete : select * from medicament");
	}
	return lesMedicaments; 
}
}
