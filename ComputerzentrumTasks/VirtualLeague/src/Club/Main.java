package Club;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			Tournament tour = new Tournament();
			
			tour.saveResultsToFile();
			tour.displayResults();

		}
		catch(IllegalArgumentException iea){
			iea.printStackTrace();
		}
		
		

	}

}
