import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MDbFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField0;
	private JTextArea movies;
	GridBagConstraints gbc = new GridBagConstraints();
	JButton searchButton;

	public MDbFrame(){
		//sets JFrame title and layout
		super("Movie Database");
		setLayout(new GridBagLayout());

		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.weighty = .1;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(new JLabel("Search by title, release year, or keyword below."), gbc);

		//adds text field to GUI
		textField0 = new JTextField(20);
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(textField0, gbc);

		searchButton = new JButton("Search");
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 30;
		gbc.weighty = 0;
		gbc.weightx = 0.5;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(searchButton, gbc);

		movies = new JTextArea();
		movies.setLineWrap(true);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.ipady = 0;
		gbc.weightx = 0;
		gbc.weighty = 0.5;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(movies, gbc);

		//creates an Action Listener
		MyHandler listener = new MyHandler();
		textField0.addActionListener(listener);
		searchButton.addActionListener(listener);
	}
	//This is what happens when the Action Listener is tripped by an event (pressing enter)
	private class MyHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){

			//If enter is pressed from in the text box, signIn is run with the text from the box
			if(event.getActionCommand().equals("TERMINATE")){
				System.exit(0);
			}
			if((event.getSource() == textField0)||(event.getSource() == searchButton)){
				//exits program when TERMINATE is entered
			}
			else{
			}
		}
	}
}
