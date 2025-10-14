package Club;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 * Represents a football player with name, birthday and strength
 */
public class Player {
	
	
	private String name;
	private LocalDate birthDay;
	private int strength;
	private Random rand = new Random();
	
	/**
	 * Constructor for a new Player object with the assigned name, birthday and position
	 * Assigns a random strength between 1-9
	 * @param name the name of the player
	 * @param birthDay the birthday of the player
	 */
	public Player(String name, LocalDate birthDay) {
		this.name = name;
		this.birthDay = birthDay;
		this.strength = rand.nextInt(9) +1;
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
	 * Returns the position of the player
	 * @return the position of the player
	 */
	public String getFunction() {
		return "Spieler";
	}
	/**
	 * Sets the strength of the player
	 * @param strength the new strength of the player
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	/**
	 * Returns the strength of the player
	 * @return the strength of the player
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Returns the age of the player based on the birthday
	 * @return the age of the player in years
	 */
	public int getAge() {
		return Period.between(this.birthDay, LocalDate.now()).getYears();
	}
}
