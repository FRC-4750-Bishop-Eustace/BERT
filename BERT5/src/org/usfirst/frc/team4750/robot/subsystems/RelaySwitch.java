package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.OI;

public class RelaySwitch extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	OI oi;

	Relay relay = new Relay(1);
	boolean debounced = true;
	boolean lightOn = false;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	/**
	 * Call this to turn the LED Ring on or off
	 * @param onOff true to turn it on, false to turn it off
	 */
	public void relaySwitch(boolean onOff) {
		SmartDashboard.putBoolean("LED Ring is:", onOff);
		
		if (onOff) {
			//Tells relay to turn on
			relay.set(Relay.Value.kForward);
		} else {
			//Tells the relay to turn off
			relay.set(Relay.Value.kOff);
		}
	}
}
