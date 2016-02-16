import javax.swing.JOptionPane;
/**
 * <h1>Movie Database</h1>
 * Movie Database (MDb) converts a plaintext file of movie data into a title-searchable database.
 * It displays information on all movies provided and filters based on a search field
 * @author Darren Midkiff
 * @version 0.0
 * @since 2016-02-05
 */
public class Driver{
	private JOptionPane display;
	
/**
 * The main method starts MDb, opening the user interface
 * @param args
 */
	public static void main(String args[]){
		Database dbase = new Database(args[0]);
		Object[] options = { "JOptionPane", "JFrame" };
		JOptionPane.showOptionDialog(null, "Which GUI would you like to use?", "Choose your GUI",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
	}
}