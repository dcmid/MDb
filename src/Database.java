import java.util.ArrayList;
import java.io.*;

public class Database{	
	protected ArrayList<Movie> movieList;
	private BufferedReader fileReader;
	
	/**
	 * Parses movie data file into ArrayList of Movie objects
	 * @return ArrayList
	 */
	private ArrayList<Movie> parseMovieList(){	
		return parseMovieList(fileReader);
	}
	protected static ArrayList<Movie> parseMovieList(BufferedReader reader){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try{
		for(String str = reader.readLine(); str != null; str = reader.readLine()){
			String movieName = "";
			String movieYear = "";
			ArrayList<String> movieInfo = new ArrayList<String>();
			int i;
			//iterates through characters until '(' is encountered, adding to movieName
			for(i = 0; str.charAt(i) != '(' && i < str.length(); i++){
				movieName += str.charAt(i);
			}
			//finds all info, adding to movieInfo
			for(char ch = str.charAt(i); Character.isWhitespace(ch) || ch == '(' || ch == ')'; i++){
				ch = str.charAt(i);
				String info = "";
				if(ch == '('){
					for(; ch != ')'; i++){
						ch = str.charAt(i);
						info += ch;
					}
					movieInfo.add(info);
				}
				ch = str.charAt(i);
			}
			//finds movieYear
			for(; i < str.length(); i++){
				char ch = str.charAt(i);
				movieYear += ch;
			}
			movies.add(new Movie(movieName, movieYear, movieInfo));
		}
		}catch(IOException x){System.out.println("Failed to read file");}
		return movies;
	}
	/**
	 * Filters movieList based on a String search parameter
	 * Returns full list if empty parameter is given
	 * @return ArrayList
	 * @param searchParam Search Parameter from user
	 */
	public ArrayList<Movie> filterMovieList(String searchParam){
		ArrayList<Movie> filtered = new ArrayList<Movie>();
		if(searchParam.equals(""))
			return movieList;
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