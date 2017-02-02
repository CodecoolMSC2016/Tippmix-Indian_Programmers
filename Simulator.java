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
		Scanner scan = new Scanner(System.in);
		log.print("Enter two team numbers(seperated by comma)", true);		
		String[] input = scan.nextLine().split(",");
		int team1Num = Integer.parseInt(input[0]),
		    team2Num = Integer.parseInt(input[1]);	
		int team1Score = 0,
		    team2Score = 0;
		String team1Name = data[team1Num-1].split("\t")[0];
		String team2Name = data[team2Num-1].split("\t")[0];
		for (String team: teamPairs){
			//System.out.println(team1Name + " ANYÁD" + team2Name + ": " + team);			
			if (team.split(":")[0].equals(team1Name) | team.split(":")[1].equals(team2Name)){
				team1Score += Integer.parseInt(team.split(":")[2]);
				team2Score += Integer.parseInt(team.split(":")[3]);
			}
			if (team.split(":")[1].equals(team1Name) | team.split(":")[0].equals(team2Name)){
				team1Score += Integer.parseInt(team.split(":")[3]);
				team2Score += Integer.parseInt(team.split(":")[2]);
			}
		}	
		//System.out.print( team1Name + ": " + team1Score + ", "+ team2Name + ": "  + team2Score);
		if (team1Score > team2Score){
			log.print("You should bet on " + team1Name, true);
		}else{
			log.print("You should bet on " + team2Name, true);
		}
		log.print("Enter the amount of money you want to bet: ", false);
		int moneyToBet = scan.nextInt();
		float prize = Simulator.estimateWinPrize(moneyToBet, data[team1Num-1].split("\t")[1], data[team2Num-1].split("\t")[1]);	
		log.print(String.valueOf(prize), true);
		//result.addTeam(teamPairs.get(0));
		
	//public String checkTeamChances(String Home_Team,String Guest_Team){}

	}
	public static float estimateWinPrize(int initialBet, String team1Power, String team2Power){
		float multiplier = Float.parseFloat(team1Power) / Float.parseFloat(team2Power);
		if (multiplier < 1) {
			return initialBet / multiplier;
		}else {
			return initialBet * multiplier;
		}
	}
}
