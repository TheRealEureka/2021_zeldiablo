package moteurJeu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * cree une interface graphique avec son controleur et son afficheur.
 * <p>
 * Cette classe est en charge de reunir et de mettre en relation les differents
 * composants.
 * 
 * @author vthomas
 */
public class InterfaceGraphique {

	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;

	/**
	 * le controleur lie a la JFrame
	 */
	private Controleur controleur;
	private JFrame f;
	/**
	 * la construction de l'interface grpahique - construit la JFrame -
	 * construit les Attributs
	 * 
	 * @param afficheurUtil
	 *            l'afficheur a utiliser dans le moteur
	 * 
	 */
	public InterfaceGraphique(DessinJeu afficheurUtil, int x, int y) {
		// creation JFrame
		 f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		// creation panel
		this.panel = new PanelDessin(x, y, afficheurUtil);
		f.setContentPane(this.panel);
		
		// ajout du controleur
		Controleur controlleurGraph = new Controleur();
		this.controleur = controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);

		// recuperation du focus
		f.pack();
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();

		f.setVisible(true);

	}

	/**
	 * retourne le controleur de l'affichage construit
	 * 
	 * @return
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * demande la mise a jour du dessin
	 */
	public void dessiner() {
		this.panel.dessinerJeu();
	}
	public void closeFrame()
	{
		this.f.dispose();
	}

}
