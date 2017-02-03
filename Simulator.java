import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class Simulator {
	public Logger log;
	public Simulation simulation;
	private static final int NAME = 0,
			                 SCORE = 1;
	
	Simulator(Simulation simulation, Logger logger){
		this.log = logger;
		this.simulation = simulation;
	}
	public String checkInput(){
		String input;
		Scanner scan = new Scanner(System.in);
		while (true){
			try {
				input = scan.nextLine();
				break;
			}catch(InputMismatchException e){}
		}
		return input;
	}

	public Result run(){
		simulation.play();
		Result result = new Result(simulation.data, simulation.matchResults);
		simulation.generateData();
		return result;

	}

	public float estimateWinPrize(int initialBet, String[] team1, String[] team2){
		float team1Score = Float.parseFloat(team1[SCORE]),
				team2Score = Float.parseFloat(team2[SCORE]);
		float multiplier = (team1Score > team2Score) ? (team1Score / team2Score):
														(team2Score / team1Score);
		return multiplier * 1.30F;
	}
}
