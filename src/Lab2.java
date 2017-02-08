import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Lab2 {
	
	public static void main(String[] args) {

		Behavior b1 = new Walk();
	    Behavior b2 = new OneDirection(SensorPort.S4);
		Behavior b3 = new Freeze(SensorPort.S2);
		Behavior [] bArray = {b1, b2 ,b3};
	    
		Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}

}


