package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoDriveForwardAndTurn extends CommandGroup {
		
	public AutoDriveForwardAndTurn(double driveSpeed, float distance, float turn){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(driveSpeed, driveSpeed, distance));
		addSequential(new TurnToHeading(turn));
		//addSequential(new AutoMove(driveSpeed, driveSpeed, driveTime));
	}

}
