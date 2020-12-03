package gsb.service;

import java.util.ArrayList;

import gsb.modele.Stocker;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class StockService {

	public static ArrayList<Stocker> checkcodevisiteur (String code){
		ArrayList<Stocker> lesStock = null;
      try{
		if (code==""){
			throw new Exception("Données obligatoires : code ");
		}
		if (VisiteurDao.rechercher(code)==null){
			throw new Exception("visisteur incorrecte ");
		}
		else{
			lesStock = StockerDao.ListeMedicament(code);
		}
      }
			
      catch(Exception e){
    	  System.out.println( e.getMessage());
      }
      return lesStock;
	}
	public static int ajoutStock (String code,String Depot,int QTE){
		String unQTE = Integer.toString(QTE);
		int retoure = 0;
		try{
			if (code==null || Depot==null && unQTE==null) {
				throw new Exception("Données obligatoires : code, depot, QTE");
			}
			if (VisiteurDao.rechercher(code)==null){
				throw new Exception("visisteur incorrecte ");
			}
			if (MedicamentDao.rechercher(Depot)==null){
				throw new Exception("Medicament incorrecte ");
			}
			else{
				
			retoure =StockerDao.Ajout(VisiteurDao.rechercher(code), MedicamentDao.rechercher(Depot),QTE);
			
			}
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return retoure;
	}
}
