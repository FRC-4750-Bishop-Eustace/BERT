package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PegDetector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// Defines sensors
	DigitalInput input = new DigitalInput(RobotMap.PEG_SENSOR);
	DigitalInput input2 = new DigitalInput(RobotMap.SECOND_PEG_SENSOR);
	DigitalInput input3 = new DigitalInput(RobotMap.THIRD_PEG_SENSOR);

	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	public boolean Output() {
		// Values inverted
		SmartDashboard.putBoolean("Peg Detector", !input.get());
		SmartDashboard.putBoolean("Peg Detector2", !input2.get());
		SmartDashboard.putBoolean("Peg Detector3", !input3.get());

		// If no sensors return true
		if (!input.get() == false && !input2.get() == false && !input3.get() == false) {
			// Turns relay switch (LED) off
			Robot.relay.relaySwitch(false);
			SmartDashboard.putBoolean("PEG Detected", false);
			return false;
		} else {
			// Else one or more returns true
			// Turns relay switch (LED) on
			Robot.relay.relaySwitch(true);
			SmartDashboard.putBoolean("PEG Detected", true);
			return true;
		}
	}

}
