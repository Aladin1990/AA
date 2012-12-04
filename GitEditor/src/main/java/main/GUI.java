package main;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame{
	GUI() {
		super("GUI");
		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel panel1 = trueFalsePanel("Panel #1");
		tabbedPane.addTab("True-False", panel1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JPanel panel2 = matchingPanel("Panel #2");
		tabbedPane.addTab("Matching", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JPanel panel3 = multiChoicePanel("Panel #3");
		tabbedPane.addTab("Multi Choice", panel3);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JPanel panel4 = shortAnswerPanel("Panel #4 (has a preferred size of 410 x 50).");
		tabbedPane.addTab("Short Answer", panel4);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		JPanel panel5 = numericalPanel("Panel #4 (has a preferred size of 410 x 50).");
		tabbedPane.addTab("Numerical", panel5);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		JPanel panel6 = calculatedPanel("Panel #4 (has a preferred size of 410 x 50).");
		tabbedPane.addTab("Calculated", panel6);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		JPanel panel7 = essayPanel("Panel #4 (has a preferred size of 410 x 50).");
		tabbedPane.addTab("Essay", panel7);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		JPanel panel8 = descriptionPanel("Panel #4 (has a preferred size of 410 x 50).");
		tabbedPane.addTab("Description", panel8);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		getContentPane().add(tabbedPane);
        setSize(660,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) 
            { System.exit(0); }
        });
	}
	

	JPanel trueFalsePanel(String panelName) {
		JPanel panel = new JPanel();
		//panel.setOpaque(false);
		panel.setLayout(new MigLayout("", "[][]", ""));
		panel.add(new TextField("bxfcbxcfhh"));
		return panel;
	}

	JPanel matchingPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}

	JPanel multiChoicePanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}

	JPanel shortAnswerPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	JPanel numericalPanel(String panelName) {
		JTabbedPane frame = new JTabbedPane();
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	JPanel calculatedPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	JPanel essayPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	JPanel descriptionPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	
}
