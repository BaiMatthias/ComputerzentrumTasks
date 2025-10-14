package Club;

import java.time.LocalDate;

/**
 * Represents a Goalkeeper from football with a name, birthday and strength
 * inherits from the superclass Player
 */
public class Goalkeeper extends Player{

	/**
	 * Constructor for a new Goalkeeper object
	 * Calls the constructor of the superclass
	 * @param name the name of the goalkeeper
	 * @param birthDay the birthday of the goalkeeper
	 */
	public Goalkeeper(String name, LocalDate birthDay) {
		super(name, birthDay);
		
	}

	/**
	 * Returns the position of the player
	 * @return the position of the player
	 */
	@Override
	public String getFunction() {
		return "Goalkeeper";
	}
	
}
