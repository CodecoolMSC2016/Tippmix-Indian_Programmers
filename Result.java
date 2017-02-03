import java.util.ArrayList;
import java.util.Random;

public class Result {
	private ArrayList<String> matchResults;
	private String[][] data;
	private static final int SCORE = 1,
			  			     NAME = 0;

	public Result(String[][] data, ArrayList<String> matchResults){
		this.matchResults = matchResults;
		this.data = data;
	}

	public ArrayList<String[]> getBestTeam(){
		ArrayList<String[]> bestTeam = new ArrayList<String[]>();
		bestTeam.add(data[0]);
		int teamScore, bestScore;
		for (String[] team: data){
			teamScore = Integer.parseInt(team[SCORE]);
			bestScore = Integer.parseInt(bestTeam.get(bestTeam.size() - 1)[SCORE]);
			if (teamScore >= bestScore){
				if(teamScore == bestScore){
					bestTeam.add(team);
				}else{
					bestTeam = new ArrayList<String[]>();
					bestTeam.add(team);
				}
			}
		}
		return bestTeam;
	}

	public ArrayList<String[]> getWorstTeam() {
		ArrayList<String[]> worstTeam = new ArrayList<String[]>();
		worstTeam.add(data[0]);
		int teamScore, worstScore;
		for (String[] team : data) {
			teamScore = Integer.parseInt(team[SCORE]);
			worstScore = Integer.parseInt(worstTeam.get(worstTeam.size() - 1)[SCORE]);
			if (teamScore <= worstScore) {
				if (teamScore == worstScore) {
					worstTeam.add(team);
				} else {
					worstTeam = new ArrayList<String[]>();
					worstTeam.add(team);
				}
			}
		}
		return worstTeam;
	}

	public String[][] getNextMatch(){
		Random random = new Random();
		String[] firstTeam,
				 secondTeam;
		do {
			firstTeam = data[random.nextInt(data.length - 1)];
			secondTeam = data[random.nextInt(data.length - 1)];
		}while(firstTeam[NAME].equals(secondTeam[NAME]));
		String[][] nextMatch =  new String[2][];
		nextMatch[0] = firstTeam;
		nextMatch[1] = secondTeam;
		return nextMatch;
	}

}
