package Club;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a football team consisting of one goalkeeper and ten fieldplayers. The team is associated with a nation.
 * Gives access to methods to get players by their positions, calculates their strength and a static method to create a new team
 */
public class Team {
	
	private Goalkeeper goalkeeper;
	private List<Player> fieldplayers;
	private String nation;
	private final static int MIN_DEFENDER = 3;
	private final static int MAX_DEFENDER = 5;
	
	private final static int MIN_MIDFIELDER = 3;
	private final static int MAX_MIDFIELDER = 5;
	
	private final static int MIN_STRIKER = 1;
	private final static int MAX_STRIKER = 3;
	
	/**
	 * Constructor to create a new Team object consisting of goalkeeper, fieldplayers and nation
	 * @param goalkeeper The player assigned as goalkeeper
	 * @param fieldplayer A list of ten fieldplayer
	 * @param nation The nation of the team
	 */
	private Team(Goalkeeper goalkeeper, List<Player> fieldplayers, String nation) {
		this.goalkeeper = goalkeeper;
		this.fieldplayers = fieldplayers;
		this.nation = nation;

	}
	/**
	 * Returns the goalkeeper of the team
	 * @return the player assigned as goalkeeper
	 */
	public Goalkeeper getGoalkeeper() {
		return this.goalkeeper;
	}
	/**
	 * Sets the goalkeeper of the team
	 * @param goalkeeper the player to assign as goalkeeper
	 */
	public void setGoalkeeper(Goalkeeper goalkeeper) {
		this.goalkeeper = goalkeeper;
	}
	/**
	 * Returns the list of fieldplayers
	 * @return a list of ten fieldplayers
	 */
	public List<Player> getFieldPlayers(){
		return this.fieldplayers;
	}
	/**
	 * Sets the fieldplayers
	 * @param fieldplayer a list of ten fieldplayers to assign to the team
	 */
	public void setFieldPlayers(List<Player> fieldplayers) {
		this.fieldplayers = fieldplayers;
	}
	/**
	 * Returns the nation of the team
	 * @return  the nation of the team
	 */
	public String getNation() {
		return this.nation;
	}
	/**
	 * Sets the nation of the team
	 * @param nation the nation to assign to the team
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	/**
	 * Returns a list of all defenders on the team
	 * @return a list containing all players on the defending position
	 */
	public List<Player> isDefense(){
		return this.fieldplayers.stream().filter(e -> e instanceof Defender).toList();
	}
	/**
	 * Returns a list of all midfielders on the team
	 * @return a list containing all players on the midfielding position
	 */
	public List<Player> isMidfield(){
		return this.fieldplayers.stream().filter(e -> e instanceof Midfielder).toList();
	}
	/**
	 * Returns a list of all strikers on the team
	 * @return a list containing all players on the striking position
	 */
	public List<Player> isStriker(){
		return this.fieldplayers.stream().filter(e -> e instanceof Striker).toList();
	}
	/**
	 * Creates a new Team object with a fixed goalkeeper and a random formation of defenders, midfielders
	 * and strikers limited by realistic role models from real football
	 * @param nation the nation to assign to the team
	 * @return A new Team object
	 */ 
	public static Team create(String nation) {
		
		Random rand = new Random();
		
		int defenderCount;
		int midfielderCount;
		int strikerCount;
		
		List<Player> fieldplayers = new ArrayList<Player>();
		
		while(true) {
			defenderCount = MIN_DEFENDER + rand.nextInt(MAX_DEFENDER - MIN_DEFENDER + 1);
			midfielderCount = MIN_MIDFIELDER + rand.nextInt(MAX_MIDFIELDER - MIN_DEFENDER + 1);
			strikerCount = 10 - defenderCount - midfielderCount;
			
			if(strikerCount >= MIN_STRIKER && strikerCount <= MAX_STRIKER) {
				break;
			}
		}
		
		int playerIndex = 1;
		Goalkeeper goalkeeper = (Goalkeeper) PlayerFactory.getPlayer(Position.GOALKEEPER, playerIndex);
		playerIndex++;
		
		for (int i = 0; i < defenderCount; i++) {
			fieldplayers.add(PlayerFactory.getPlayer(Position.DEFENDER, playerIndex));
		}
		for (int i = 0; i < midfielderCount; i++) {
			fieldplayers.add(PlayerFactory.getPlayer(Position.MIDFIELDER, playerIndex));
		}
		for (int i = 0; i < strikerCount; i++) {
			fieldplayers.add(PlayerFactory.getPlayer(Position.STRIKER, playerIndex));
		}
		
		
		return new Team(goalkeeper, fieldplayers, nation);
	}
	
	/**
	 * Adds up the power of the goalkeeper and fieldplayers
	 * @return the combined strength of goalkeeper and fieldplayers
	 */
	public int getPower() {
		return this.goalkeeper.getStrength() + this.fieldplayers.stream().mapToInt(e -> e.getStrength()).sum();
	}
	
	
	
	/**
	 * Returns a String containing information about the team including the 
	 * player's names, their ages and positions
	 * @return A String containing information about the team and it's players
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(this.nation).append("\n");
        sb.append(String.format("%s %d %s\n", 
            this.goalkeeper.getName(), 
            this.goalkeeper.getAge(), 
            this.goalkeeper.getFunction()));
        
        for (Player player : this.fieldplayers) {
            sb.append(String.format("%s %d %s\n", 
                player.getName(), 
                player.getAge(), 
                player.getFunction()));
        }
        
        return sb.toString();
		
		
		
	}
	
}
