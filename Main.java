public class Main{

	private static Simulation generateSimulation(int round){
		return Simulation.load();	
	}

	public static void main(String[] args){
		Logger logger = new Logger();
		Simulator simulator =  new Simulator(generateSimulation(args[0]), logger);
		simulator.run();
	}
	

}
