package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.service.OffrirService;
import gsb.service.StockService;

public class JIFOffrir extends JInternalFrame implements ActionListener{
	
	protected JPanel pMain;
	protected JPanel p;  
	protected JTextField JTcodeVisiteur;
	protected JTextField JTDepot;
	protected JTextField JTQTE;
	
	protected JLabel JTLcode;
	protected JLabel JTLDepot;
	protected JLabel JTLQTE;
	
	protected JButton button;
	
	
	public JIFOffrir(MenuPrincipal uneFenetreContainer) {
		
		p= new JPanel(new GridLayout(3,3));
		pMain = new JPanel(new GridLayout(2,1));
		
		
		JTLcode = new JLabel("Code visiteur");
		JTLDepot = new JLabel("Depot légal");
		JTLQTE = new JLabel("Quantité");
		JTcodeVisiteur = new JTextField(20);
		JTDepot = new JTextField(20);
		JTQTE = new JTextField(20);
		
		JButton button = new JButton("ajouté quantité");
		button.addActionListener(this);
		
		p.add(JTLcode);
		p.add(JTcodeVisiteur);
		p.add(JTLDepot);
		p.add(JTDepot);
		p.add(JTLQTE);
		p.add(JTQTE);
		pMain.add(p);
		pMain.add(button);
		
        Container contentPane = getContentPane();
        contentPane.add(pMain);

		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String codev =JTcodeVisiteur.getText();
		String Depot =JTDepot.getText();
		String QTE =JTLQTE.getText();
		//int uneQTE = Integer.valueOf(QTE);

		StockService.ajoutStock(codev, Depot, 10);
	}

}
