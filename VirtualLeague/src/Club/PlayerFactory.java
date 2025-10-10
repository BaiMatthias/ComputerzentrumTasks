package Club;

import java.time.LocalDate;
import java.util.Random;

/**
 * Represents a simple factory which creates and returns player objects depending on the needed positions.
 */
public final class PlayerFactory {
	
	private static final Random RAND = new Random();
	/**
	 * Creates and returns a new Goalkeeper, Defender, Midfielder or Striker Object depending on the position needed
	 * @param position the position the new player should be assigned to
	 * @param playerIndex sequential number for better naming for the players
	 * @return a new Goalkeeper, Defender, Midfielder or Striker Object depending on the position needed
	 */
	public static Player getPlayer(final Position position, int playerIndex) {
		
		
		
	     LocalDate today = LocalDate.now();

	     int minAge = 18;
	     int maxAge = 36;

	     LocalDate maxBirthday = today.minusYears(minAge);
	     LocalDate minBirthday = today.minusYears(maxAge);

	     long daysBetween = maxBirthday.toEpochDay() - minBirthday.toEpochDay();
	     
	     LocalDate randomBirthday = minBirthday.plusDays(RAND.nextLong(daysBetween + 1));
	        
		return switch (position) {
		case Position.GOALKEEPER -> new Goalkeeper(position.toString() + playerIndex, randomBirthday);
		case Position.DEFENDER -> new Defender(position.toString() + playerIndex, randomBirthday);
		case Position.MIDFIELDER -> new Midfielder(position.toString() + playerIndex, randomBirthday);
		case Position.STRIKER -> new Striker(position.toString() + playerIndex, randomBirthday);
		default -> 
			throw new IllegalArgumentException("Unexpected position: " + position);
		
		};
		
	}

}
