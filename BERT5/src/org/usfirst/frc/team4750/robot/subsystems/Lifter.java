package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {

	// Defines motor
	VictorSP lifterMotor = new VictorSP(RobotMap.LIFTER_MOTOR);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void setLifterSpeed(double lifterSpeed) {
		// Sets motor speed from RobotMap
		lifterMotor.set(lifterSpeed);
	}

}
