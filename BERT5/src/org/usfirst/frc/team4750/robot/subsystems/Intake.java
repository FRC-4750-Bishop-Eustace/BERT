package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	// Defines motor
	VictorSP intakeMotor = new VictorSP(RobotMap.INTAKE_MOTOR);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void setIntakeSpeed(double intakeMotorSpeed) {
		// TODO Auto-generated method stub
		// Sets motor speed from RobotMap
		intakeMotor.set(intakeMotorSpeed);
	}

}
