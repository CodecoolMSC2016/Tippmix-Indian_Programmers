import java.io.*;

public class Simulation {
	private String[] data;
	public Simulation() {
		/**this.home_team;
		this.guest_team;
		this.home_score;
		this.guest_score;
		this.odds;
		this.data = load();		
		//Stores the data in instance variable.**/
	} 

	public static void load() {
		try {		
			FileReader in = new FileReader("Teams.csv");
			int c = 0;
			String text = null;			
			while (c != -1){
				 c = in.read();
				text += (char)c;

			}
			System.out.println(text.split("\t"));
		}catch(FileNotFoundException e){
		}catch(IOException e){}
		//Loads from CSV file and return the result.
	}
	public void generateData() {
		//Write simulated round to CSV file.
		
	}


}
