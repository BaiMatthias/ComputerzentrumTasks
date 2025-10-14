package Club;

import java.time.LocalDate;

/**
 * Represents a Defender from football with a name, birthday and strength
 * inherits from the superclass Player
 */
public class Defender extends Player{

	/**
	 * Constructor for a new Defender object
	 * Calls the constructor of the superclass
	 * @param name the name of the Defender
	 * @param birthDay the birthday of the Defender
	 */
	public Defender(String name, LocalDate birthDay) {
		super(name, birthDay);
	}
	
	/**
	 * Returns the position of the player
	 * @return the position of the player
	 */
	@Override
	public String getFunction() {
		return "Defender";
	}
	

}
