package Club;

import java.time.LocalDate;
/**
 * Represents a Midfielder from football with a name, birthday and strength
 * inherits from the superclass Player
 */
public class Midfielder extends Player{

	/**
	 * Constructor for a new Midfielder object
	 * Calls the constructor of the superclass
	 * @param name the name of the Midfielder
	 * @param birthDay the birthday of the Midfielder
	 */
	public Midfielder(String name, LocalDate birthDay) {
		super(name, birthDay);
		
	}
	/**
	 * Returns the position of the player
	 * @return the position of the player
	 */
	@Override
	public String getFunction() {
		return "Midfielder";
	}

}
