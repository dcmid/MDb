import java.util.ArrayList;
import java.io.*;

public class Database{	
	private ArrayList<Movie> movieList;
	private BufferedReader fileReader;
	
	/**
	 * Parses movie data file into ArrayList of Movie objects
	 * @return ArrayList
	 */
	protected ArrayList<Movie> parseMovieList(){	
		return parseMovieList(fileReader);
	}
	private static ArrayList<Movie> parseMovieList(BufferedReader reader){	
		return null;
	}
	/**
	 * Filters movieList based on a String search parameter
	 * Returns full list if empty parameter is given
	 * @return ArrayList
	 * @param searchParam Search Parameter from user
	 */
	public ArrayList<Movie> filterMovieList(String searchParam){
		ArrayList<Movie> filtered = new ArrayList<Movie>();
		for(Movie movie:movieList){
			if(movie.getName().indexOf(searchParam) > -1 || movie.getYear().indexOf(searchParam) > -1)
				filtered.add(movie);
			else
				for(String info:movie.getInfo())
					if(movie.getName().indexOf(info) > -1){
						filtered.add(movie);
						break;
					}
			
		}
		return filtered;
	}
	
	/**
	 * Constructor for Database
	 * @param dataFileLocation
	 */
	public Database(String dataFileLocation){
		try{
		FileReader r = new FileReader(dataFileLocation);
		fileReader = new BufferedReader(r);
		}catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");}
		movieList = parseMovieList(fileReader);
	}
}