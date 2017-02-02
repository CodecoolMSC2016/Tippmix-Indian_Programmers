import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
	public static ArrayList<ArrayList<String>> teamPairs;
	public Logger log;
	public float odds;
	
	Simulator(Simulation simulation, Logger logger){ // add Logger paramater
		this.teamPairs = simulation.teamPairs;
		this.log = logger;
		
		
		
	}
		
	public void run(){
		//for (ArrayList team: teamPairs){			
		//	log.print(team.get(0).toString());
		//	log.print(team.get(1).toString());
		//}
		Result result = new Result();
		result.addTeam(teamPairs.get(0));
		
		
	}
	public static void estimateWinPrize(int InitialBet){
		float estimationalOdds = 0.0f;
		for (ArrayList<String> match:teamPairs){
			String[] odds=match.split(":");
		estimationalOdds+=(float)odds[(odds.length-1)];
		System.out.print(estimationalOdds);}
}
}
