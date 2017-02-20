package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoDriveForwardAndTurn extends CommandGroup {
		
	public AutoDriveForwardAndTurn(double driveSpeed, double driveTime, double turnSpeed, double turnTime){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(driveSpeed, driveSpeed, driveTime));
		addSequential(new AutoMove(turnSpeed, -turnSpeed, turnTime));
	}

}
