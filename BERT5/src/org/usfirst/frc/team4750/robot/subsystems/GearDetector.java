package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearDetector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	double x;// just a place holder till i run test to figure out the values
	AnalogInput input = new AnalogInput(RobotMap.GEAR_SENSOR);

	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public boolean Output(){
		//Voltage increases as object gets closer
		SmartDashboard.putNumber("Gear Detector", input.getVoltage());
		
		if(input.getVoltage() == x){
			return true;
		}
		
		
		
		return false;
	}
}