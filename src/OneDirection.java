import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class OneDirection implements Behavior{
	private boolean suppressed;
	
	private DifferentialPilot pilot;
	private UltrasonicSensor ultra;
	
	public OneDirection(SensorPort s1) {
	     pilot = new DifferentialPilot(5.6f, 14.0f, Motor.A, Motor.C );
	     ultra = new UltrasonicSensor(s1);
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ultra.getDistance() < 32;
	}

	@Override
	public void action() {
		System.out.println("Behavior: One direction");
		suppressed = false;
		
		pilot.rotate(140);
		// TODO Auto-generated method stub
		
		while( pilot.isMoving() && !suppressed ){
			Thread.yield();		 	   
	    }	         
	    pilot.stop();		
	}

	@Override
	public void suppress() {
		suppressed = true;
		// TODO Auto-generated method stub
		
	}

}
