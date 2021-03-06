package civilisation.inspecteur.simulation.dialogues;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import civilisation.Configuration;
import civilisation.individu.cognitons.TypeDeCogniton;
import civilisation.inspecteur.simulation.GCogniton;
import civilisation.inspecteur.simulation.environnement.PanelEnvironnement;

public class DialogueSelectionnerEnvironnementActif extends JDialog implements ActionListener, PropertyChangeListener{
	
	JComboBox listeEnvironnements;
    JOptionPane optionPane;
    PanelEnvironnement p;
    
	public DialogueSelectionnerEnvironnementActif(Frame f , boolean modal , PanelEnvironnement p){
		super(f,modal);

		this.p = p;
		listeEnvironnements = new JComboBox();

		File[] files = new File(System.getProperty("user.dir")+"/bin/civilisation/ressources/environnements").listFiles();

		for (int i = 0; i < files.length; i++){
			listeEnvironnements.addItem(files[i].getName());
		}
		
		this.setTitle("Enregistrer un environnement");
		
		
	    Object[] array = {listeEnvironnements};
	       

	    Object[] options = {"Valider" , "Annuler"};
	 
	    optionPane = new JOptionPane(array,
	                                    JOptionPane.QUESTION_MESSAGE,
	                                    JOptionPane.YES_NO_OPTION,
	                                    null,
	                                    options,
	                                    options[0]); 

	    setContentPane(optionPane);
	        
	    optionPane.addPropertyChangeListener(this);
	        
		
		this.pack();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println(optionPane.getValue());
		if (isVisible()){
			if (optionPane.getValue().equals("Valider")){
				Configuration.environnementACharger = ((String) (listeEnvironnements.getSelectedItem())).split(Configuration.getExtension())[0];
			}		
	        setVisible(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
