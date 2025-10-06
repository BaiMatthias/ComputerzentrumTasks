package Club;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			List<Player> playersteam1 = new ArrayList<>();
			// Team 1
			Player goalkeeper1 = new Player("Player1",  LocalDate.of(2000,12,5), Position.GOALKEEPER);
			// Player goalkeeper1 = new Player("Player1",  LocalDate.of(2000,12,5), Position.STRIKER); // Exception
			
			playersteam1.add(new Player("Player2", LocalDate.of(2001, 7, 12), Position.DEFENDER));
			playersteam1.add(new Player("Player3", LocalDate.of(1999, 11, 30), Position.DEFENDER));
			playersteam1.add(new Player("Player4", LocalDate.of(2006, 2, 25), Position.DEFENDER));
			playersteam1.add(new Player("Player5", LocalDate.of(2004, 9, 18), Position.DEFENDER));
		    
			playersteam1.add(new Player("Player6", LocalDate.of(2004, 2, 11), Position.MIDFIELDER));
			playersteam1.add(new Player("Player7", LocalDate.of(2002, 9, 19), Position.MIDFIELDER));
			playersteam1.add(new Player("Player8", LocalDate.of(2000, 11, 25), Position.MIDFIELDER));
	        
			playersteam1.add(new Player("Player9", LocalDate.of(2000, 2, 20), Position.STRIKER));
			playersteam1.add(new Player("Player10", LocalDate.of(1998, 9, 10), Position.STRIKER));
			playersteam1.add(new Player("Player11", LocalDate.of(2007, 4, 12), Position.STRIKER));
			// playersteam1.add(goalkeeper1); // Exception
			playersteam1.add(new Player("Player6", LocalDate.of(2004, 2, 11), Position.MIDFIELDER)); // Exception
			
			Team team1 = Team.create(goalkeeper1, playersteam1, "Brazil");
			
	        // Team 2
			List<Player> playersteam2 = new ArrayList<>();
			
	        Player goalkeeper2 = new Player("Player12", LocalDate.of(2005, 8, 22), Position.GOALKEEPER);
	        
	        playersteam2.add(new Player("Player13", LocalDate.of(2002, 4, 5), Position.DEFENDER));
	        playersteam2.add(new Player("Player14", LocalDate.of(2000, 12, 1), Position.DEFENDER));
	        playersteam2.add(new Player("Player15", LocalDate.of(1998, 6, 14), Position.DEFENDER));
	        playersteam2.add(new Player("Player16", LocalDate.of(2007, 1, 20), Position.DEFENDER));
	        
	        playersteam2.add(new Player("Player17", LocalDate.of(1998, 4, 13), Position.MIDFIELDER));
	        playersteam2.add(new Player("Player18", LocalDate.of(2007, 6, 17), Position.MIDFIELDER));
	        playersteam2.add(new Player("Player19", LocalDate.of(2005, 12, 2), Position.MIDFIELDER));
	        playersteam2.add(new Player("Player20", LocalDate.of(2003, 8, 28), Position.MIDFIELDER));
			
	        playersteam2.add(new Player("Player21", LocalDate.of(2005, 11, 5), Position.STRIKER));
	        playersteam2.add(new Player("Player22", LocalDate.of(2003, 6, 18), Position.STRIKER));
	        
	        
	        Team team2 = Team.create(goalkeeper2, playersteam2, "England");
	        
	        //Team 3
	        List<Player> playersteam3 = new ArrayList<>();
	        
	        Player goalkeeper3 = new Player("Player23", LocalDate.of(2003, 3, 10), Position.GOALKEEPER);
	        
	        playersteam3.add(new Player("Player24", LocalDate.of(2005, 10, 8), Position.DEFENDER));
	        playersteam3.add(new Player("Player25", LocalDate.of(2003, 5, 27), Position.DEFENDER));
	        playersteam3.add(new Player("Player26", LocalDate.of(2001, 8, 16), Position.DEFENDER));
	        playersteam3.add(new Player("Player27", LocalDate.of(1999, 3, 4), Position.DEFENDER));
	        
	        playersteam3.add(new Player("Player28", LocalDate.of(2001, 1, 15), Position.MIDFIELDER));
	        playersteam3.add(new Player("Player29", LocalDate.of(1999, 5, 23), Position.MIDFIELDER));
	        playersteam3.add(new Player("Player30", LocalDate.of(2006, 3, 9), Position.MIDFIELDER));
	        playersteam3.add(new Player("Player31", LocalDate.of(2004, 10, 7), Position.MIDFIELDER));
	        playersteam3.add(new Player("Player32", LocalDate.of(2002, 7, 14), Position.MIDFIELDER));
	        
	        playersteam3.add(new Player("Player33", LocalDate.of(2006, 7, 22), Position.STRIKER));

	        Team team3 = Team.create(goalkeeper3, playersteam3, "Germany");
	        
	        System.out.println(team1.toString());
	        System.out.println(team2.toString());
	        System.out.println(team3.toString());

	        
	       

		}
		catch(IllegalArgumentException iea){
			iea.printStackTrace();
		}
		
		

	}

}
