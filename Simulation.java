import java.io.*;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;


public class Simulation {
	static String[][] data;
	ArrayList<String> matchResults;
	private int rounds;
	private static final int NAME = 0,
						     SCORE = 1;

	public Simulation(int rounds) {
		load("Teams.csv");
		matchResults = new ArrayList<String>();
		this.rounds = rounds;
	}

	public void play() {
		Integer[] chosenTeams;
		for (int i = 0; i < rounds; i++) {
			chosenTeams = compareTeams();
			pickWinner(chosenTeams);
		}
	}

	public Integer[] compareTeams() {
		Random random = new Random();
		int dataLength = data.length - 1,
				team1 = random.nextInt(dataLength),
				team2 = random.nextInt(dataLength),
				stronger,
				weaker;
		Integer team1Score = Integer.parseInt(data[team1][SCORE]),
				team2Score = Integer.parseInt(data[team2][SCORE]);
		if (team1Score > team2Score) {
			stronger = team1;
			weaker = team2;
		} else {
			stronger = team2;
			weaker = team1;
		}
		return new Integer[]{stronger, weaker};
	}

	public void pickWinner(Integer[] teams) {
		Random random = new Random();
		String strCache1, strCache2,
				winnerName, loserName;
		Integer stronger = teams[0],
				weaker = teams[1],
				matchOutcome = random.nextInt(100),
				strongerScore = Integer.parseInt(data[stronger][SCORE]),
				weakerScore = Integer.parseInt(data[weaker][SCORE]),
				goalDiff;
		double chanceToWin = (strongerScore / weakerScore)*10 + 50;

		if (random.nextInt(100) > chanceToWin) {
			strCache1 = String.valueOf(strongerScore + random.nextInt(100));
			data[stronger][SCORE] = strCache1;
			winnerName = data[stronger][NAME];
			loserName = data[weaker][NAME];
			goalDiff = random.nextInt(5);
		} else {
			strCache1 = String.valueOf(weakerScore + random.nextInt(100));
			data[weaker][SCORE] = strCache1;
			winnerName = data[weaker][NAME];
			loserName = data[stronger][NAME];
			goalDiff = random.nextInt(3);
		}
		matchResults.add(winnerName + " vs. " + loserName +  " ---> "
				+ winnerName + " won by " + (goalDiff + 1) + " goals!");
	}

	public static void load(String filename) {
		try {		
			FileReader in = new FileReader(filename);
			int c = 0;
			String text = "";
			do {
				c = in.read();
				text += (char)c;
			}while((c != -1));
			String[] textArray = text.split("\n");
			data = new String[textArray.length-1][];
			for (int row = 0; row < textArray.length-1; row++){
				data[row] = textArray[row].split("\t");
			}
		} catch(FileNotFoundException e) {
		} catch(IOException e) {}

	}

	public void generateData() {
		try {
    		PrintWriter writer = new PrintWriter("history.csv", "UTF-8");
			for (int i = 0; i < data.length - 1; i++){
				writer.println(data[i][0] + "\t" + data[i][1]);
			}
			writer.close();
		}catch (IOException e) {}
	}
}
