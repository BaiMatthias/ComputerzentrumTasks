package Club;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import GUI.ResultFrame;

/**
 * Represents a class which lets different team play against each other in a knockout system until a winner is decided
 * provides methodes to show results on the console or GUI and saves it to a textfile
 */
public class  Tournament{
	
	private List<Team> teams;
	Random rand = new Random();
	private List<String> tournamentResults;
	
	/**
	 * Constructor for a new Tournamen object.
	 * Creates the teams for the tournament and calls the method to play the tournament
	 *  and save and show the results
	 */
	public Tournament() {
		this.teams = createTeams();
		this.tournamentResults = new ArrayList<String>();
		startTournament();
		saveResultsToFile();
		displayResults();
		
	}

	/**
	 * Creates new random teams with the provided nations
	 * @return a List containing random teams
	 */
	private List<Team> createTeams() {
		List<String> nations = Arrays.asList(
	            "Germany", "Brazil", "Argentina", "France",
	            "Spain", "Italy", "England", "Portugal"
	        );
		List<Team> createdTeams = new ArrayList<Team>();
		for(String nation : nations) {
			createdTeams.add(Team.create(nation));
		}
		return createdTeams;
	}
	
	/**
	 * simulates a tournament by having matches with two nations in a knockout system until one team remains
	 * which is declared the winner
	 */
	private void startTournament() {
		if(!isTournamentSizeCorrect(teams.size())) throw new IllegalArgumentException("Wrong number of teams");
		
		while(teams.size() != 1) {
			Collections.shuffle(this.teams);
			
            List<Team> winners = new ArrayList<>();
            this.tournamentResults.add("Qualified for this round: " + String.join(", ", 
				    teams.stream().map(Team::getNation).toList()));
			for (int i = 0; i < this.teams.size(); i += 2) {
				
				Team team1 = this.teams.get(i);
				Team team2 = this.teams.get(i+1);
				
				Team winner = this.playMatch(team1, team2);
				this.tournamentResults.add(winner.getNation() + " wins.");
				winners.add(winner);
				
			}
			
			teams = winners;
			
		}
		
		this.tournamentResults.add(this.teams.get(0).getNation() + " wins the tournament!");	
	}

	/**
	 * Simulates a match between two teams by comparing their each combined strength multiplied by a
	 * random factor. If both teams have the same strength, a random team wins
	 * @param team1 a team to participate in the match 
	 * @param team2 a team to participate in the match 
	 * @return the winning team
	 */
	private Team playMatch(Team team1, Team team2) {
		
		int team1Performance = (int) (team1.getPower() * (50 + rand.nextInt(51)) / 100.0);
		int team2Performance = (int) (team2.getPower() * (50 + rand.nextInt(51)) / 100.0);
		this.tournamentResults.add(team1.getNation() + " (" + team1Performance +") vs. " + team2.getNation() + " (" + team2Performance+")");
		if(team1Performance > team2Performance) return team1;
		else if (team1Performance < team2Performance) return team2;
		else {
			if (rand.nextBoolean()) {
	            return team1;
	        } else {
	            return team2;
	        }
		}
	}
	
	/**
	 * Checks bitwise if the amount of teams is the power of 2
	 * to resemble a real tournament
	 * e.g. 4,8, 16, 32
	 * @param i the amount of teams that needs to be checked
	 * @return true if the amount of team is the power of 2 false if not
	 */
	private boolean isTournamentSizeCorrect(int i) {
		 return (i != 0) && ((i & (i - 1)) == 0);
    }
	/**
	 * Saves the results of each match to a text file
	 */
	private void saveResultsToFile() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Tournament Results\n");
            sb.append("==================\n");
            for (String result : this.tournamentResults) {
                sb.append(result).append("\n");
            }
            Files.write(Paths.get("tournament_results.txt"), sb.toString().getBytes());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
	/**
	 * Initializes the gui and makes it visible
	 */
	private void displayResults() {
		ResultFrame resultframe = new ResultFrame();
		resultframe.setVisible(true);
		
	}
	/**
	 * Creates a String containing details about the tournament
	 * including each match and it's winner
	 * @return a String containing information about the tournament
	 */
	private String getTournamentResults() {
		StringBuilder sb = new StringBuilder();
        sb.append("Tournament Results\n");
        sb.append("==================\n");
        for (String result : this.tournamentResults) {
            sb.append(result).append("\n");
        }
        return sb.toString();
	}


}
