package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame implements DataAccess {
	JTextArea textArea;

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

		JPanel panel4 = shortAnswerPanel("Panel #4");
		tabbedPane.addTab("Short Answer", panel4);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		JPanel panel5 = numericalPanel("Panel #5");
		tabbedPane.addTab("Numerical", panel5);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		JPanel panel6 = calculatedPanel("Panel #6");
		tabbedPane.addTab("Calculated", panel6);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		JPanel panel7 = essayPanel("Panel #7 ");
		tabbedPane.addTab("Essay", panel7);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		JPanel panel8 = descriptionPanel("Panel #8");
		tabbedPane.addTab("Description", panel8);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		getContentPane().add(tabbedPane);
		setSize(660, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	JPanel trueFalsePanel(String panelName) {
		JPanel panel = new JPanel();
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow,]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "grow,gapy 20");
		
		JButton clearbtn = new JButton("Clear Text");
		panel.add(clearbtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");

		panel.add(new JLabel("Correct Answer"), "skip,split 5");
		ButtonGroup radioGroupbtn = new ButtonGroup();
		JRadioButton truebtn = new JRadioButton("True");
		JRadioButton falsebtn = new JRadioButton("False");
		radioGroupbtn.add(truebtn);
		radioGroupbtn.add(falsebtn);
		panel.add(truebtn);
		panel.add(falsebtn,"wrap");
		
		JButton savebtn = new JButton("Save Question");
		panel.add(savebtn,"gapy 20");
		clearbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText("");
			}
		});
		savebtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText("Question Saved");
			}
		});

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
	class DrawLine extends JPanel {
		
		public Dimension getPreferredSize() {
			return new Dimension(240, 50);
		}
		
		protected void paintComponent(Graphics g) {
			g.setColor( Color.blue );
			// X Start, Y Start, X End, Y End
			g.drawLine ( 0, 0, 1000, 0 );
	 
		}
	}

}
