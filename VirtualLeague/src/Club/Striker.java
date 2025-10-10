package Club;

import java.time.LocalDate;
/**
 * Represents a Striker from football with a name, birthday and strength
 * inherits from the superclass Player
 */
public class Striker extends Player{
	/**
	 * Constructor for a new Striker object
	 * Calls the constructor of the superclass
	 * @param name the name of the Striker
	 * @param birthDay the birthday of the Striker
	 */
	public Striker(String name, LocalDate birthDay) {
		super(name, birthDay);
	}
	
	/**
	 * Returns the position of the player
	 * @return the position of the player
	 */
	@Override
	public String getFunction() {
		return "Striker";
	}

}
