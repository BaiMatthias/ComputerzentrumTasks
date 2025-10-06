package Club;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a football player with name, birthday and position
 */
public class Player {
	
	
	private String name;
	private LocalDate birthDay;
	private Position position;
	
	/**
	 * Constructor for a new Player object with the assigned name, birthday and position
	 * @param name the name of the player
	 * @param birthDay the birthday of the player
	 * @param position the position the player is assigned to
	 */
	public Player(String name, LocalDate birthDay, Position position) {
		this.name = name;
		this.birthDay = birthDay;
		this.position = position;
	}
	
	/**
	 * Sets the name of the player
	 * @param name the new name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the name of the player
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Sets the birthday of the Player
	 * @param birthDay the new birthday of the player
	 */
	public void setBirthday(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * Returns the birthday of the player
	 * @return the birthday of the player
	 */
	public LocalDate getBirthday() {
		return this.birthDay;
	}
	/**
	 * Sets the position of the player
	 * @param position the new position of the player
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * Returns the position of the player
	 * @return the position of the player
	 */
	public Position getPosition() {
		return this.position;
	}
	/**
	 * Returns the age of the player based on the birthday
	 * @return the age of the player in years
	 */
	public int getAge() {
		return Period.between(this.birthDay, LocalDate.now()).getYears();
	}
}
