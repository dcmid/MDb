import java.util.ArrayList;
import java.io.*;

public class Database{	
	protected MovieList movieList;
	private BufferedReader fileReader;
	
	/**
	 * Parses movie data file into ArrayList of Movie objects
	 * @return ArrayList
	 */
	protected static MovieList parseMovieList(BufferedReader reader){
		MovieList movies = new MovieList();
		try{
		for(String str = reader.readLine(); str != null; str = reader.readLine()){
			String movieName = "";
			String movieYear = "";
			ArrayList<String> movieInfo = new ArrayList<String>();
			int i;
			//iterates through characters until '(' is encountered, adding to movieName
			for(i = 0; i < str.length() && !(str.charAt(i) == '(' && (str.charAt(i+1) == '?' || Character.isDigit(str.charAt(i+1)))); i++)
				movieName += str.charAt(i);
			
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
			i--;
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
	 * @param searchType 0 searches all fields, 1 searches name, 2 searches year
	 */
	public MovieList filterMovieList(String searchParam, int searchType){
		MovieList filtered = new MovieList();
		if(searchParam.equals(""))
			return movieList;
		for(Movie movie:movieList){
			if((movie.getName().toLowerCase().contains(searchParam.toLowerCase()) && searchType != 2) || (movie.getYear().contains(searchParam)) && searchType != 1)
				filtered.add(movie);
			else if(searchType == 0)
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