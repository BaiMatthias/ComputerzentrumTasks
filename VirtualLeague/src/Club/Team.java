package Club;

import java.util.List;

/**
 * Represents a football team consisting of one goalkeeper and ten fieldplayers. The team is associated with a nation.
 * Gives access to methods to get players by their positions and a static method to create a new team
 */
public class Team {
	
	private Player goalkeeper;
	private List<Player> fieldplayer;
	private String nation;
	
	/**
	 * Constructor to create a new Team object consisting of goalkeeper, fieldplayers and nation
	 * @param goalkeeper The player assigned as goalkeeper
	 * @param fieldplayer A list of ten fieldplayer
	 * @param nation The nation of the team
	 */
	private Team(Player goalkeeper, List<Player> fieldplayer, String nation) {
		this.goalkeeper = goalkeeper;
		this.fieldplayer = fieldplayer;
		this.nation = nation;

	}
	/**
	 * Returns the goalkeeper of the team
	 * @return the player assigned as goalkeeper
	 */
	public Player getGoalkeeper() {
		return this.goalkeeper;
	}
	/**
	 * Sets the goalkeeper of the team
	 * @param goalkeeper the player to assign as goalkeeper
	 */
	public void setGoalkeeper(Player goalkeeper) {
		this.goalkeeper = goalkeeper;
	}
	/**
	 * Returns the list of fieldplayers
	 * @return a list of ten fieldplayers
	 */
	public List<Player> getFieldPlayer(){
		return this.fieldplayer;
	}
	/**
	 * Sets the fieldplayers
	 * @param fieldplayer a list of ten fieldplayers to assign to the team
	 */
	public void setFieldPlayer(List<Player> fieldplayer) {
		this.fieldplayer = fieldplayer;
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
		return this.fieldplayer.stream().filter(e -> e.getPosition() == Position.DEFENDER).toList();
	}
	/**
	 * Returns a list of all midfielders on the team
	 * @return a list containing all players on the midfielding position
	 */
	public List<Player> isMidfield(){
		return this.fieldplayer.stream().filter(e -> e.getPosition() == Position.MIDFIELDER).toList();
	}
	/**
	 * Returns a list of all strikers on the team
	 * @return a list containing all players on the striking position
	 */
	public List<Player> isStriker(){
		return this.fieldplayer.stream().filter(e -> e.getPosition() == Position.STRIKER).toList();
	}
	/**
	 * Creates a new Team object with the assigned goalkeeper, fieldplayers and nation.
	 * Checks for the correct position for the goalkeeper and that there only ten non-goalkeeper 
	 * fieldplayers
	 * @param goalkeeper the player to assign as goalkeeper
	 * @param fieldplayer fieldplayer a list of ten fieldplayers to assign to the team
	 * @param nation the nation to assign to the team
	 * @return A new Team object
	 * @throws IllegalArgumentException if the goalkeeper don't has the goalkeeper position or if 
	 * 									there are not ten non-goalkeeper fieldplayers
	 */ 
	public static Team create(Player goalkeeper, List<Player> fieldplayer, String nation) {
		
		if(goalkeeper.getPosition() != Position.GOALKEEPER) {
			throw new IllegalArgumentException("Missing goalkeeper on goalkeeper position");
		}
		if(fieldplayer.size() != 10) {
			throw new IllegalArgumentException("A team must have exactly 10 fieldplayers");
		}
		if(fieldplayer.stream().filter(e -> e.getPosition() == Position.GOALKEEPER).count() > 0) {
			throw new IllegalArgumentException("Goalkeeper on fieldplayer position");
		}
		
		return new Team(goalkeeper, fieldplayer, nation);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(this.nation).append("\n");
        sb.append(String.format("%s %d %s\n", 
            this.goalkeeper.getName(), 
            this.goalkeeper.getAge(), 
            this.goalkeeper.getPosition()));
        
        for (Player player : this.fieldplayer) {
            sb.append(String.format("%s %d %s\n", 
                player.getName(), 
                player.getAge(), 
                player.getPosition()));
        }
        
        return sb.toString();
		
		
		
	}
	
}
