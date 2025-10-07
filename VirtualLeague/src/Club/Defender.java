package Club;

import java.time.LocalDate;

public class Defender extends Player{

	public Defender(String name, LocalDate birthDay, int strength) {
		super(name, birthDay, strength);
	}
	
	@Override
	public String getFunction() {
		return "Defender";
	}
	

}
