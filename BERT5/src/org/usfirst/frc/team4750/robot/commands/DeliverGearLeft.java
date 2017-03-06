package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeft extends CommandGroup {
	
	public DeliverGearLeft(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.6f));
		addSequential(new TurnToHeading(60f));
		addSequential(new AutoMove(.3, -.3, 2.6f));
	}

}
