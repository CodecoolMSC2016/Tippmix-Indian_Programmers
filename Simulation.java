import java.io.*;
import java.util.Random;
import java.util.ArrayList;


public class Simulation {
	static String[] data;
	public ArrayList<String> teamPairs;
	public float odds;
	public Simulation(int rounds) {
		teamPairs = new ArrayList<String>();
		Random teamnumber = new Random();
		Random score= new Random();
		load();
		for(int i = 0; i < rounds; i++) {
			String team1=data[teamnumber.nextInt(data.length -1)];
			String force1=team1.split("\t")[1];
			team1 = team1.split("\t")[0];
			String team2=data[teamnumber.nextInt(data.length -1)];
			String force2=team2.split("\t")[1];
			team2 = team2.split("\t")[0];
			float odds = (float)Integer.parseInt(force1)/Integer.parseInt(force2);
			String MatchData=team1 + ": " + team2 + ":"+ score.nextInt(10) + ":"+ score.nextInt(10)+ ":" + odds;
			teamPairs.add(MatchData);
		}
		System.out.println(teamPairs);
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
			String[] splitText = text.split("\n");
			data = new String[splitText.length];
			data = splitText;
		} catch(FileNotFoundException e) {
		} catch(IOException e) {}

	}
	public void generateData() {
		//Write simulated round to CSV file.
		
	}


}
