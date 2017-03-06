package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearRight extends CommandGroup {
	
	public DeliverGearRight(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.6f));
		addSequential(new TurnToHeading(-60f));
		addSequential(new AutoMove(.3, -.3, 2.6f));
		addSequential(new WaitForGear());
		addSequential(new AutoMove(-.3, .3, .3f));
		addSequential(new TurnToHeading(60f));
		addSequential(new AutoMove(1, -1, 1f));
	}

}
