import java.util.ArrayList;

public class MovieList extends ArrayList<Movie>{
	public MovieList(){
		super();
	}
	
	@Override
	public String toString(){
		String str = "";
		for(Movie m:this)
			str+=m.getName() + " --- " + m.getYear() + "\n";
		return str;
	}
}
