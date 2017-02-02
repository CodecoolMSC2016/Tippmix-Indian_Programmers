import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class Simulation {
	static String[] data;
	public ArrayList<String> teamPairs;
	public float odds;
	public Simulation(int rounds) {
		teamPairs = new ArrayList<String>();
		Random teamnumber = new Random();
		Random score= new Random();
		load("Teams.csv");
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
		
	} 

	public static void load(String filename) {
		try {		
			FileReader in = new FileReader(filename);
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
	//public String checkTeamChances(String Home_Team,String Guest_Team){}
	public void generateData()
	{try{
    	PrintWriter writer = new PrintWriter("History.csv", "UTF-8");
	int serial=0;
    	for(String matches:teamPairs){
		serial++;
		writer.println(serial + ". " +matches);}
    		writer.close();
	} catch (IOException e) {}
		//Write simulated round to CSV file.
		
	}


}
