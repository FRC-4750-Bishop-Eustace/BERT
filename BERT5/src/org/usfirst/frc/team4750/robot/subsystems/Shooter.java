package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	// Defines motor
	VictorSP shooterMotor = new VictorSP(RobotMap.SHOOTER_MOTOR);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void setShooterSpeed(double speed) {
		// SmartDashboard.putBoolean("is Shooter running", true);

		// Sets motor speed from RobotMap
		shooterMotor.set(speed);
	}

}
