package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoDriveForwardAndTurn extends CommandGroup {
		
	public AutoDriveForwardAndTurn(double driveSpeed, double time, float turn){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(driveSpeed, -driveSpeed, time));
		addSequential(new TurnToHeading(turn));
		addSequential(new AutoMove(driveSpeed, -driveSpeed, time));
	}

}
