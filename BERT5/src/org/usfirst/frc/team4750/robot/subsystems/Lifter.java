package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	// this defines the motor for the victor
	VictorSP lifterMotor = new VictorSP(RobotMap.LIFTER_MOTOR);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setLifterSpeed(double lifterSpeed){
		// this just sets the motor to a speed that is a placeholder
		lifterMotor.set(lifterSpeed);
	}

}
