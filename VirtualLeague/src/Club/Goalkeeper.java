package Club;

import java.time.LocalDate;

public class Goalkeeper extends Player{


	public Goalkeeper(String name, LocalDate birthDay, int strength) {
		super(name, birthDay, strength);
		
	}

	



	@Override
	public String getFunction() {
		return "Goalkeeper";
	}
	
}
