import java.util.ArrayList;

import javax.swing.*;
/**
 * <h1>Movie Database</h1>
 * Movie Database (MDb) converts a plaintext file of movie data into a title-searchable database.
 * It displays information on all movies provided and filters based on a search field
 * @author Darren Midkiff
 * @version 0.0
 * @since 2016-02-05
 */
public class Driver{
	
/**
 * The main method starts MDb, opening the user interface
 * @param args
 */
	public static void main(String args[]){
		String searchParam;
		MovieList filteredMovies;
		String moviesString = "";
		int guiSelection;
		Database dbase = new Database(args[0]);
		Object[] options = { "JOptionPane", "JFrame" };
		guiSelection = JOptionPane.showOptionDialog(null, "Which GUI would you like to use?", "Choose your GUI",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
		if(guiSelection == 0){
			searchParam = JOptionPane.showInputDialog(null, "What yo search param, mah digger?");
			filteredMovies = dbase.filterMovieList(searchParam);
			moviesString = String.valueOf(filteredMovies.size()) + " Results:\n\n";
			for(Movie m:filteredMovies)
				moviesString += m.getName() + "--- " + m.getYear() + "\n";
			JOptionPane.showMessageDialog(null, moviesString);
		}
		else{
			MDbFrame frame = new MDbFrame(dbase.filterMovieList(""));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
}