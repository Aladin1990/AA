package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame implements DataAccess {
	JTextArea textArea;
	JPanel scrollPanel = new JPanel(new MigLayout("wrap 1","grow, fill",""));
	JPanel scrollPane2 = new JPanel(new MigLayout("wrap 1","grow, fill",""));
	JPanel scrollPane3 = new JPanel(new MigLayout("wrap 1","grow, fill",""));
	int numberOfQustions=0;
	String onlyNumbers;

	GUI() {
		super("GIFT Format Creator");
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

		JPanel panel6 = missingWordPanel("Panel #6");
		tabbedPane.addTab("Missing Word", panel6);
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
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "growx,gapy 20");
		
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
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");
		
		JButton addbtn;
		addbtn = new JButton("Add Q&A");
		panel.add(addbtn,"right, top,gapy 20");
		panel.add(new JScrollPane(scrollPanel), "grow,right,gapy 20");
		
		JButton deletebtn = new JButton("Delete Selected");
		panel.add(deletebtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");

		JButton savebtn = new JButton("Save Question");
		panel.add(savebtn,"gapy 20");
		addbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scrollPanel.add(getQuestinandAnswerPane());
				repaint();
				numberOfQustions++;
			}
			private JPanel getQuestinandAnswerPane() {
				JPanel panel1 = new JPanel();
				panel1.setLayout(new MigLayout("", "[][grow][][grow][]", "grow"));
				char letter= (char) ('A'+numberOfQustions);
				
				panel1.add(new JLabel(""+letter));
				panel1.add(new JTextField(),"grow");
				panel1.add(new JLabel(""+letter));
				panel1.add(new JTextField(),"grow");
				panel1.add(new JCheckBox("Delete"),"right");
				return panel1;
			}

		});
		deletebtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		savebtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		return panel;
	}

	JPanel multiChoicePanel(String panelName) {
		JPanel panel = new JPanel();
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "growx,hmax 90,hmin 90,gapy 20");
		
		JButton clearbtn = new JButton("Clear Text");
		panel.add(clearbtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");
		
		JButton addansbtn;
		addansbtn = new JButton("Add Answer");
		panel.add(addansbtn,"right, top,gapy 10");
		panel.add(new JScrollPane(scrollPane2), "grow,hmax 90,hmin 90,right,gapy 10");
		
		
		JButton savebtn = new JButton("Save Question");
		panel.add(savebtn,"gapy 10");
		
		addansbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scrollPane2.add(getQuestinandAnswerPane());
				repaint();
				numberOfQustions++;
			}
			private JPanel getQuestinandAnswerPane() {
				JPanel panel1 = new JPanel();
				panel1.setLayout(new MigLayout("", "[grow, fill][]", "grow"));
				SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);
				panel1.add(new JTextField(),"growx");
				panel1.add(new JSpinner(sm));
				return panel1;
			}

		});
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

	JPanel shortAnswerPanel(String panelName) {
		JPanel panel = new JPanel();
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "growx,hmax 90,hmin 90,gapy 20");
		
		JButton clearbtn = new JButton("Clear Text");
		panel.add(clearbtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");
		
		JButton addansbtn;
		addansbtn = new JButton("Add Answer");
		panel.add(addansbtn,"right, top,gapy 10");
		panel.add(new JScrollPane(scrollPane3), "grow,hmax 90,hmin 90,right,gapy 10");
		
		
		JButton savebtn = new JButton("Save Question");
		panel.add(savebtn,"gapy 10");
		
		addansbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scrollPane3.add(getQuestinandAnswerPane());
				repaint();
				numberOfQustions++;
			}
			private JPanel getQuestinandAnswerPane() {
				JPanel panel1 = new JPanel();
				panel1.add(new JLabel("Correct Answer: "),"al right");
				panel1.setLayout(new MigLayout("", "[][grow, fill]", "grow"));
				panel1.add(new JTextField(),"growx");
			
				return panel1;
			}

		});
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

	JPanel numericalPanel(String panelName) {
		JPanel panel = new JPanel();
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "growx,gapy 20");
		
		JButton clearbtn = new JButton("Clear Text");
		panel.add(clearbtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");
		final JTextField text1 = new JTextField();
		final JTextField text2 = new JTextField();
		final JTextField text3 = new JTextField();
		panel.add(new JLabel("Correct Answer"));
		panel.add(text1 ,"growx");
		panel.add(new JLabel("Min Margin: "),"skip,split 4");
		panel.add(text2 ,"growx");
		panel.add(new JLabel("Max Margin: "));
		panel.add(text3 ,"growx");
		
		JButton savebtn = new JButton("Save Question");
		panel.add(savebtn,"gapy 20");
		text1 .addKeyListener(new KeyAdapter() {
	            public void keyReleased(KeyEvent e) {
	            	//e.getSource();
	            }
	        });
		text2 .addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	e.getSource();
            	int charCode = e.getKeyChar();
            	text1.setText(""+e.getKeyChar());
            	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            		//text1.setText("Enter numerals only in this field.");
            		text2.setText(onlyNumbers);
                   // return false;
                   }
                   // return true;
            }
            public void keyPressed(KeyEvent e) {
            	onlyNumbers=text2.getText();
            	text2.setText(onlyNumbers);
            }
        });
		text3 .addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	//e.getSource();
            }
            public void keyPressed(KeyEvent e) {
                // TODO: Do something for the keyPressed event
            }
        });
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

	JPanel missingWordPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}

	JPanel essayPanel(String panelName) {
		JPanel panel = new JPanel();
		// panel.setOpaque(false);
		panel.setLayout(new MigLayout("wrap 2", "[][grow]", "grow"));
		textArea = new JTextArea("", 20, 20);

		panel.add(new JLabel("Question Title (optional)"), "right");
		panel.add(new JTextField(), "growx,right,gapy 10");

		panel.add(new JLabel("Question"), "right,top,gapy 20");
		panel.add(new JScrollPane(textArea), "growx,gapy 20");
		
		JButton clearbtn = new JButton("Clear Text");
		panel.add(clearbtn, "skip,al right,wrap");
		
		panel.add( new DrawLine(),"skip 1");
		
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

	JPanel descriptionPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		return panel;
	}
	
	class DrawLine extends JPanel {
		
		public Dimension getPreferredSize() {
			return new Dimension(520, 20);
		}
		
		protected void paintComponent(Graphics g) {
			g.setColor( Color.red );
			// X Start, Y Start, X End, Y End
			g.drawLine ( 0, 0, 1000, 0 );
	 
		}
	}

}
