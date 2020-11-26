package gsb.tests;

import java.awt.print.Printable;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
public class fillStock {
	public static void main(String[] args) {
		for(Visiteur visi : VisiteurDao.retournerLesVisiteurs()){
			for(Medicament Med : MedicamentDao.retournerlesMedicaments()){
			StockerDao.creer(Med, visi, 20);
			}
		}
		
	}
	
	
}
