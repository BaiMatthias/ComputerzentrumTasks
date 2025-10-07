package Club;

import java.time.LocalDate;

public class Midfielder extends Player{

	public Midfielder(String name, LocalDate birthDay,int strength) {
		super(name, birthDay, strength);
		
	}
	
	@Override
	public String getFunction() {
		return "Midfielder";
	}

}
