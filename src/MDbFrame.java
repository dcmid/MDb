import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MDbFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JTextField textField;
	private ButtonGroup searchType = new ButtonGroup();
	private JRadioButton rdbtnTitle = new JRadioButton("Title");
	private JRadioButton rdbtnReleaseYear = new JRadioButton("Release Year");
	private JRadioButton rdbtnKeyword = new JRadioButton("Keyword");
	private JTextArea displayArea;
	private JScrollPane scroll;
	private Database dbase;
	private MovieList movies;

	/**
	 * Create the frame.
	 */
	public MDbFrame (Database dbase) {
		movies = dbase.movieList;
		MyHandler listener = new MyHandler();
		this.dbase = dbase;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 432);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectSearchType = new JLabel("Select search type and enter parameter below. Keyword searches all info on movies.");
		lblSelectSearchType.setBounds(5, 5, 569, 14);
		contentPane.add(lblSelectSearchType);
		
		
		searchType.add(rdbtnKeyword);
		rdbtnKeyword.setBounds(5, 24, 98, 23);
		contentPane.add(rdbtnKeyword);
		
		
		searchType.add(rdbtnTitle);
		rdbtnTitle.setBounds(105, 24, 79, 23);
		contentPane.add(rdbtnTitle);
		
		searchType.add(rdbtnReleaseYear);
		rdbtnReleaseYear.setBounds(186, 24, 113, 23);
		contentPane.add(rdbtnReleaseYear);
		
		textField = new JTextField();
		textField.setBounds(5, 52, 618, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(listener);
		
		displayArea = new JTextArea(movies.toString());
		displayArea.setEditable(false);
		displayArea.setBounds(10, 105, 398, 145);
		displayArea.setSelectionStart(0);
		displayArea.setSelectionEnd(0);
		scroll = new JScrollPane (displayArea);
		scroll.setBounds(5, 77, 618, 305);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		this.setTitle("Movie Database");
		searchType.setSelected(rdbtnKeyword.getModel(), true);
	}
	

	private class MyHandler implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent event){
		}

		@Override
		public void keyReleased(KeyEvent event) {
			if(rdbtnTitle.isSelected())
				displayArea.setText(dbase.filterMovieList(textField.getText(),1).toString());
			else if(rdbtnReleaseYear.isSelected())
				displayArea.setText(dbase.filterMovieList(textField.getText(),2).toString());
			else
				displayArea.setText(dbase.filterMovieList(textField.getText(),0).toString());
			displayArea.repaint();
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}
	}
}
