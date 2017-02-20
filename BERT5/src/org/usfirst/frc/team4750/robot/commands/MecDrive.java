package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class MecDrive extends Command {
	//AHRS ahrs;

	public MecDrive(){
//		SmartDashboard.putBoolean("MecDrive.MecDrive()", true);
		requires(Robot.driveTrain);
	}
	
	protected void initialize(){
//		SmartDashboard.putBoolean("MecDrive.initialize()", true);
		requires(Robot.driveTrain);
	}
	
	protected void execute(){
		//this can used to test to see if a command is running for debugging
		SmartDashboard.putBoolean("Is MecDrive executing?", true);
		//SmartDashboard.putNumber("DisplacementY", ahrs.getDisplacementY());
		Robot.driveTrain.controllerDrive(Robot.oi.driveStick);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
//		SmartDashboard.putBoolean("MecDrive.isFinished()", true);
		return false;
	}
	
	protected void end(){
//		SmartDashboard.putBoolean("MecDrive.end()", true);
		Robot.driveTrain.setDriveMotors(0, 0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
//		SmartDashboard.putBoolean("MecDrive.interrupted()", true);
		//end();
	}

}
