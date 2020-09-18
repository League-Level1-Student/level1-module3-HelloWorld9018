package _05_netflix;

public class NetflixPlayer {
public static void main(String[] args) {
	Movie movie1 = new Movie("The Twilight Zone", 4);
	Movie movie2 = new Movie("Twilight", 0);
	Movie movie3 = new Movie("Star Trek", 2);
	Movie movie4 = new Movie("9 Lives", 5);
	Movie movie5 = new Movie("Spongebob: The Live Action", 1);
	
	System.out.println(movie2.getTicketPrice());
	
	NetflixQueue movieBox = new NetflixQueue();
	movieBox.addMovie(movie1);
	movieBox.addMovie(movie2);
	movieBox.addMovie(movie3);
	movieBox.addMovie(movie4);
	movieBox.addMovie(movie5);
	
	movieBox.printMovies();
	
	System.out.println("The best movie is " + movieBox.getBestMovie());
	
	System.out.println("The second best movie is " + movieBox.getMovie(1));
	
	
}
}
