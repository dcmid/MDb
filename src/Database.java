import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Database{	
	private ArrayList<Movie> movieList;
	private Scanner scan;
	private File dataFile;
	
	/**
	 * Parses movie data file into ArrayList of Movie objects
	 * @return ArrayList
	 */
	protected ArrayList<Movie> parseMovieList(){	
		return null;
	}
	
	
	/**
	 * Filters movieList based on a String search parameter
	 * Returns full list if empty parameter is given
	 * @return ArrayList
	 * @param searchParam Search Parameter from user
	 */
	public ArrayList<Movie> filterMovieList(String searchParam){
		return null;
	}
	
	/**
	 * Constructor for Database
	 * @param dataFileLocation
	 */
	public Database(String dataFileLocation){
		
	}
}