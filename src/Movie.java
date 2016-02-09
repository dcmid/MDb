import java.util.ArrayList;

public class Movie{
	private String name;
	private String year;
	private ArrayList<String> info;
	
	/**
	 * Retrieves value of this.name
	 * @return String
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Retrieves value of this.year
	 * @return String
	 */
	public String getYear(){
		return year;
	}
	
	/**
	 * Retrieves value of this.info
	 * @return ArrayList
	 */
	public ArrayList<String> getInfo(){
		return info;
	}
	
	/**
	 * Constructor for Movie class
	 * @param name name
	 * @param year year
	 * @param info list of remaining
	 */
	public Movie(String name, String year, ArrayList<String> info){
		this.name = name;
		this.year = year;
		this.info = info;
		
	}
}