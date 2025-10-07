package Club;

import java.time.LocalDate;

public class Striker extends Player{

	public Striker(String name, LocalDate birthDay,int strength) {
		super(name, birthDay, strength);
	}
	
	
	@Override
	public String getFunction() {
		return "Striker";
	}

}
