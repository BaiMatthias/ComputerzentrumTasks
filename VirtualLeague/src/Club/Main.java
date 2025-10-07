package Club;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			List<Player> playersteam1 = new ArrayList<>();
			// Team 1
			Goalkeeper goalkeeper1 = new Goalkeeper("Player1",  LocalDate.of(2000,12,5), 8);
			
			playersteam1.add(new Defender("Player2", LocalDate.of(2001, 7, 12), 6));
			playersteam1.add(new Defender("Player3", LocalDate.of(1999, 11, 30), 7));
			playersteam1.add(new Defender("Player4", LocalDate.of(2006, 2, 25), 7));
			playersteam1.add(new Defender("Player5", LocalDate.of(2004, 9, 18), 5));
		    
			playersteam1.add(new Midfielder("Player6", LocalDate.of(2004, 2, 11), 7));
			playersteam1.add(new Midfielder("Player7", LocalDate.of(2002, 9, 19), 6));
			playersteam1.add(new Midfielder("Player8", LocalDate.of(2000, 11, 25), 4));
	        
			playersteam1.add(new Striker("Player9", LocalDate.of(2000, 2, 20), 9));
			playersteam1.add(new Striker("Player10", LocalDate.of(1998, 9, 10), 6));
			playersteam1.add(new Striker("Player11", LocalDate.of(2007, 4, 12), 3));
			
			
			
			Team team1 = Team.create(goalkeeper1, playersteam1, "Brazil");
			
	       System.out.println(team1.toString());
	       
	       
	       Player spieler1 = new Player("Player9", LocalDate.of(2000, 2, 20), 9); 
	       System.out.println(spieler1.getFunction()); // Spieler
	       Goalkeeper torwart = new Goalkeeper("Player1",  LocalDate.of(2000,12,5), 8);
	       System.out.println(torwart.getFunction());  // Goalkeeper
	       Player spieler2 = new Midfielder("Player6", LocalDate.of(2004, 2, 11), 7); 
	       System.out.println(spieler2.getFunction()); // Midfielder

	        
	       

		}
		catch(IllegalArgumentException iea){
			iea.printStackTrace();
		}
		
		

	}

}
