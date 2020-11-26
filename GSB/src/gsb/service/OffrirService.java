package gsb.service;

import java.util.ArrayList;

import gsb.modele.Stocker;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class OffrirService {
	
	public static void ajoutStock (String code,String Depot,int QTE){
		String unQTE = Integer.toString(QTE);
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
				System.out.println( "test");
			StockerDao.Ajout(VisiteurDao.rechercher(code), MedicamentDao.rechercher(Depot),QTE);
			}
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
	}
}
