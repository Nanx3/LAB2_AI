import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;

public class Freeze implements Behavior {
	
	private boolean suppressed;
	
	private DifferentialPilot pilot;
	private SoundSensor sound;
	
	public Freeze(SensorPort port) {
	     pilot = new DifferentialPilot(5.6f, 14.0f, Motor.A, Motor.B );
	     sound = new SoundSensor(port);
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		System.out.print("Read Value: " + sound.readValue());
		return sound.readValue() >= 64;
	}

	@Override
	public void action() {
		System.out.println("Behavior: Freeze");
		suppressed = false;
		//pilot.stop();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(pilot.isMoving() && !suppressed) {
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
