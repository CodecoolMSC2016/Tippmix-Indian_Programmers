import java.util.ArrayList;

public class Simulator {
	public ArrayList<ArrayList<String>> teamPairs;
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
}
