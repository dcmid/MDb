import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class DatabaseTests {
	Database data = new Database("StarTrekMovies.txt");
	
	@Test
	public void testParseMovieList() {
		//This list is found using parseMovieList
		ArrayList<Movie> movies = data.movieList;
		assertTrue(movies.size()>0);
	}
	
	@Test
	public void testFilterMovieList() {
		ArrayList<Movie> movies = data.movieList;
		System.out.println(movies);
		if(movies.size() == 0)
			fail("No movie info parsed");
		Movie movie1 = movies.get(0);
		Movie movie2 = movies.get(movies.size() - 1);
		
		assertEquals(data.filterMovieList("",0), movies);
		assertTrue(data.filterMovieList(movie1.getName().toString(),1).contains(movie1));
		assertTrue(data.filterMovieList(movie2.getYear().toString(),2).contains(movie2));
	}

}
