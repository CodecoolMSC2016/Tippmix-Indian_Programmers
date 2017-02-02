public class Main{

	public static Simulation generateSimulation(int round){
		// returns a Simulation instance
		Simulation sim = new Simulation(round);
		sim.generateData();
		return sim;	
	}

	public static void main(String[] args){
		/*Logger logger = new Logger();
		Simulator simulator =  new Simulator(generateSimulation(), logger);
		simulator.run();
		*/
		Logger log = new Logger();
		Simulator simulator = new Simulator(generateSimulation(10000), log);
		//simulator.run();
		//simulator.estimateWinPrize(200);
		
		
	}
	
	
}
