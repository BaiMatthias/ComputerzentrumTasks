package Club;

import java.util.List;

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
	 * Creates a new Team object with the assigned goalkeeper, fieldplayers and nation.
	 * Checks for the correct position for the goalkeeper and that there only ten non-goalkeeper 
	 * fieldplayers
	 * @param goalkeeper the player to assign as goalkeeper
	 * @param fieldplayer fieldplayer a list of ten fieldplayers to assign to the team
	 * @param nation the nation to assign to the team
	 * @return A new Team object
	 * @throws IllegalArgumentException if the goalkeeper don't has the goalkeeper position, if 
	 * 									there are not ten non-goalkeeper fieldplayers or if there is an
	 *                                  unrealistic amount of defenders, midfielders or strikers
	 */ 
	public static Team create(Goalkeeper goalkeeper, List<Player> fieldplayers, String nation) {
		
		if (fieldplayers.stream().anyMatch(e -> e instanceof Goalkeeper)) {
			throw new IllegalArgumentException("Goalkeeper on fieldplayer position");
		}
		long defenderCount = fieldplayers.stream().filter(e -> e instanceof Defender).count();
		if (defenderCount < MIN_DEFENDER || defenderCount > MAX_DEFENDER) {
			throw new IllegalArgumentException("Invalid amount of Defenders. Must be between " + MIN_DEFENDER + " and " + MAX_DEFENDER);
		}
		long midfielderCount = fieldplayers.stream().filter(e -> e instanceof Midfielder).count();
		if (midfielderCount < MIN_MIDFIELDER || midfielderCount > MAX_MIDFIELDER) {
			throw new IllegalArgumentException("Invalid amount of Midfielders. Must be between " + MIN_MIDFIELDER + " and " + MAX_MIDFIELDER);
		}
		long strikerCount = fieldplayers.stream().filter(e -> e instanceof Striker).count();
		if (strikerCount < MIN_STRIKER || strikerCount > MAX_STRIKER) {
			throw new IllegalArgumentException("Invalid amount of Strikers. Must be between " + MIN_STRIKER + " and " + MAX_STRIKER);
		}
		if (defenderCount + midfielderCount + strikerCount != 10) {
		    throw new IllegalArgumentException("Invalid formation");
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
