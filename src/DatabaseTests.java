import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class DatabaseTests {
	Database data = new Database("/testData/movies.odt");
	@Test
	public void testFilterMovieList() {
		ArrayList<Movie> movies = data.parseMovieList();
		if(movies.size() == 0)
			fail("No movie info parsed");
		Movie movie1 = movies.get(0);
		Movie movie2 = movies.get(movies.size() - 1);
		
		assertEquals(data.filterMovieList(""), movies);
		assertEquals(data.filterMovieList(movie1.getName()).get(0), movie1);
		assertEquals(data.filterMovieList(movie2.getName()).get(0), movie2);
	}

}
