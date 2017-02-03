import java.util.Scanner;
import java.util.ArrayList;

public class Main{

	public static Simulation generateSimulation(int round){
		Simulation sim = new Simulation(round);
		sim.generateData();
		return sim;	
	}

	public static void main(String[] args){
		final int NAME = 0,
				  SCORE = 1;
		Logger log = new Logger();
		Scanner scan = new Scanner(System.in);
		log.print("Enter the amount of matches you want to simulate: ");
		int rounds = scan.nextInt();
		Simulator simulator = new Simulator(generateSimulation(rounds), log);
		Result result = simulator.run();
		log.print("Print match results? Y/N");
		if (simulator.checkInput().toLowerCase().equals("y")){
			log.printTable(simulator.simulation.matchResults);
		}
		ArrayList<String[]> worstTeam = result.getWorstTeam();
		log.print("The worst team(s) in the league: ");
		for (String[] team: worstTeam){
			log.print("\t" + team[NAME] + " - " + team[SCORE]);
		}
		ArrayList<String[]> bestTeam = result.getBestTeam();
		log.print("\nThe best team(s) in the league: ");
			for (String[] team: bestTeam){
				log.print("\t" + team[NAME] + " - " + team[SCORE]);
			}
		String[][] nextMatch = result.getNextMatch();
		log.print("\n\nNext Match:");
		String[] betterTeam = nextMatch[0];
		for (String[] team: nextMatch){
			if (Integer.parseInt(team[SCORE]) > Integer.parseInt(betterTeam[SCORE])){
				betterTeam = team;
			}
			log.print("\t" + team[NAME] + " - " + team[SCORE]);
		}
		log.print("\nYou should bet on " + betterTeam[NAME]);
		log.print("How much are you going to bet?");
		int initialBet = Integer.parseInt(simulator.checkInput());
		float multiplier = simulator.estimateWinPrize(initialBet,betterTeam, nextMatch[1]);
		float winnings = multiplier * initialBet;
		log.print("Amount you earn if the team wins: " +  Math.round(winnings) + " Ft.");;
	}
}
