import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
	public static ArrayList<String> teamPairs;
	public Logger log;
	public float odds;
	public String[] data;
	
	Simulator(Simulation simulation, Logger logger){ // add Logger paramater
		this.teamPairs = simulation.teamPairs;
		this.log = logger;
		this.data = simulation.data;
		
		
		
	}
		
	public void run(){
	log.printTeamTable(data);
		//result.addTeam(teamPairs.get(0));
		
	/*public String checkTeamChances(String Home_Team,String Guest_Team){}

	}
	public static void estimateWinPrize(int InitialBet){
		float estimationalOdds = 0.0f;
		for (String match:teamPairs){
			String[] odds=match.split(":");
		estimationalOdds+=Float.parseFloat(odds[(odds.length-1)]);
		System.out.print(estimationalOdds);}*/
}
}
