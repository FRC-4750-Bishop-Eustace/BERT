package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RangeDetector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	int x; // this is just a placeholder till i do some test to figure out the values of the sensor.
	AnalogInput input = new AnalogInput(RobotMap.RANGE_SENSOR);

	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public boolean Output(){
		//Voltage increases as object gets closer
		SmartDashboard.putNumber("Range Detector", input.getVoltage());
		
		if(input.getVoltage() == x){
			return true;
		}else if(input.getVoltage() == x){
			return false;
		}
		return false;
	}
}