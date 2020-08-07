package _01_intro_to_static;

public class Athlete {
	

    public static void main(String[] args) {
        //create two athletes
    	Athlete one = new Athlete("Timmy", 12);
    	System.out.println("Timmy");
    	System.out.println(one.bibNumber= 1);
    	System.out.println(raceLocation = "California");
    	System.out.println(raceStartTime = "6.00am");
    	
    	Athlete two = new Athlete("Bob", 10);
        //print their names, bibNumbers, and the location of their race. 
    	System.out.println("Bob");
    	System.out.println(nextBibNumber = one.bibNumber + 1);
    	System.out.println(raceLocation);
    	System.out.println(raceStartTime);
    	
    	
    
    }
static int nextBibNumber;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    String name;
    int speed;
    int bibNumber;

    Athlete (String name, int speed){
        this.name = name;
        this.speed = speed;
    }
}
