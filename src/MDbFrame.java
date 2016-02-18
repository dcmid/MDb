import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MDbFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JTextField textField;
	protected ButtonGroup searchType = new ButtonGroup();
	JTextArea displayArea;
	JScrollPane scroll;

	/**
	 * Create the frame.
	 */
	public MDbFrame(MovieList movies) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 366, 0};
		gbl_contentPane.rowHeights = new int[]{14, 23, 20, 145, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSelectSearchType = new JLabel("Select search type and enter parameter below.");
		GridBagConstraints gbc_lblSelectSearchType = new GridBagConstraints();
		gbc_lblSelectSearchType.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSelectSearchType.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectSearchType.gridwidth = 2;
		gbc_lblSelectSearchType.gridx = 0;
		gbc_lblSelectSearchType.gridy = 0;
		contentPane.add(lblSelectSearchType, gbc_lblSelectSearchType);
		
		JRadioButton rdbtnTitle = new JRadioButton("Title");
		searchType.add(rdbtnTitle);
		GridBagConstraints gbc_rdbtnTitle = new GridBagConstraints();
		gbc_rdbtnTitle.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnTitle.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTitle.gridx = 0;
		gbc_rdbtnTitle.gridy = 1;
		contentPane.add(rdbtnTitle, gbc_rdbtnTitle);
		
		JRadioButton rdbtnReleaseYear = new JRadioButton("Release Year");
		searchType.add(rdbtnReleaseYear);
		GridBagConstraints gbc_rdbtnReleaseYear = new GridBagConstraints();
		gbc_rdbtnReleaseYear.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnReleaseYear.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnReleaseYear.gridx = 1;
		gbc_rdbtnReleaseYear.gridy = 1;
		contentPane.add(rdbtnReleaseYear, gbc_rdbtnReleaseYear);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		displayArea = new JTextArea(movies.toString());
		displayArea.setEditable(false);
		displayArea.setBounds(10, 105, 398, 145);
		scroll = new JScrollPane (displayArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scroll = new GridBagConstraints();
		gbc_scroll.fill = GridBagConstraints.BOTH;
		gbc_scroll.gridwidth = 2;
		gbc_scroll.gridx = 0;
		gbc_scroll.gridy = 3;
		contentPane.add(scroll, gbc_scroll);;
	}
	
	private void updateTextArea(String str){
		
	}
	

	//This is what happens when the Action Listener is tripped by an event (pressing enter)
	private class MyHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){

			//If enter is pressed from in the text box, signIn is run with the text from the box
			if((event.getSource() == textField)){
				
			}
			else{
			}
		}
	}
}
