package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Stocker;
import gsb.modele.dao.MedecinDao;
import gsb.service.StockService;

public class JIFStock extends JInternalFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pcode;
	protected JPanel ptab;
	protected JButton button;
	protected JPanel pBoutons;
	protected JPanel pSaisie;
	protected JTextField JTcodeVisiteur;
	
	protected JLabel JTcode;
	private JScrollPane scroll;
	private JTable table;
	
	int i=0;
	String[][] data = new String[50][3] ;
	
	public JIFStock(MenuPrincipal uneFenetreContainer) {
    	p = new JPanel();  // panneau principal de la fenêtre
        pcode = new JPanel(new GridLayout(1,2,-100,-100));
        ptab= new JPanel(new GridLayout(1,1));
        pBoutons = new JPanel(new GridLayout(1,1));

        
        JTcode = new JLabel("Code visiteur");
        pcode.add(JTcode);
        pSaisie = new JPanel();
        JTcodeVisiteur = new JTextField(20);
        JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		pSaisie.add(JTcodeVisiteur);
		pcode.add(pSaisie);
        p.add(pcode);
        

        
        String[] entetes = {"code", "Nom","stock"};
        
		table= new JTable(data, entetes);   //initialiser le tableau
		scroll= new JScrollPane(table);  
		
		JButton button = new JButton("Actualiser");
		button.addActionListener(this);
		
        ptab.add(scroll);
        p.add(ptab);
        pBoutons.add(button);
        p.add(pBoutons);
        Container contentPane = getContentPane();
        contentPane.add(p);

		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de méthode auto-généré

			ArrayList<Stocker> lesStock = StockService.checkcodevisiteur(JTcodeVisiteur.getText());
			for(Stocker unStock : lesStock){
				data[i][0] = unStock.getUnVisiteur().getMatricule();
				data[i][1] = unStock.getUnMedicament().getCodeFamille();
				String QTE = Integer.toString(unStock.getQteStock());
				data[i][2] = QTE ;
				i++;
			}
		}
	}

