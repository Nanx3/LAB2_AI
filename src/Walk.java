import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class Walk implements Behavior {
	private boolean suppressed = false;
	DifferentialPilot pilot = new DifferentialPilot(5.6f, 10.0f, Motor.A, Motor.C );

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
	    System.out.println("Behavior: Walk");
	    pilot.forward();
	  
	    while( !suppressed ){
	        Thread.yield();
	    }
	 
	    pilot.stop();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		 suppressed = true;
		// TODO Auto-generated method stub		
	}

}
