package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PegDetector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	DigitalInput input = new DigitalInput(RobotMap.PEG_SENSOR);
	DigitalInput input2 = new DigitalInput(RobotMap.SECOND_PEG_SENSOR);

	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public boolean Output() {
		SmartDashboard.putBoolean("Peg Detector", !input.get());
		SmartDashboard.putBoolean("Peg Detector2", !input.get());
		if(!input.get() == false){
			return false;
		}else if(!input.get() == true){
			return true;
		}
		return false;
	}

}
