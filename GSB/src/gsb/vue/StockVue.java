package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockVue extends JInternalFrame implements ActionListener{
	protected JPanel p;
	protected JPanel pTexte;
	protected JLabel JLcode;
	
	private static final long serialVersionUID = 1L;
	

		public StockVue() {
		super();
		pTexte = new JPanel(new GridLayout(9,2));
		JLcode = new JLabel("Code");
		pTexte.add(JLcode);
		p.add(pTexte);
	
		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}


	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
