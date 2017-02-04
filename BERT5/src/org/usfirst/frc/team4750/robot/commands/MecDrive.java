package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

/**
 *
 */
public class MecDrive extends Command {
	double leftSpeed, rightSpeed;
	
	public MecDrive() {
		requires(Robot.driveTrain);
		//this.leftSpeed = 0;
		//this.rightSpeed = 0;
		
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		/*
		Robot.driveTrain.setLeftDriveMotor(leftSpeed);
		Robot.driveTrain.setRightDriveMotor(rightSpeed);
		*/
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putBoolean("Is MechDrive executing?", true);
		Robot.driveTrain.controllerDrive(Robot.oi.driveStick);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
