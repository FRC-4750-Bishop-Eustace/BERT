package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooterSpeed extends Command {

	protected void execute() {
		// Sets shooter and agitator motor speeds from RobotMap
		Robot.shooter.setShooterSpeed(RobotMap.SHOOTER_MOTOR_SPEED);
		Robot.agitator.setAgitatorSpeed(RobotMap.AGITATOR_MOTOR_SPEED);
		Robot.agitator.setAgitator2Speed(RobotMap.AGITATOR2_MOTOR_SPEED);

		// SmartDashboard.putBoolean("is SetShooterSpeed running?" , true);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// Sets motor speeds to 0
		Robot.shooter.setShooterSpeed(0);
		Robot.agitator.setAgitatorSpeed(0);
		Robot.agitator.setAgitator2Speed(0);
	}

}