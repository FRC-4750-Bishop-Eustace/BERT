package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideBlue extends CommandGroup {
	
	public DeliverGearLeftSideBlue(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.15f));
		addSequential(new TurnToHeading(48f));
		addSequential(new TrackGear());
		addSequential(new AutoMove(.3, -.3, 1.7f));
		addSequential(new WaitForGear());
		addSequential(new AutoMove(-.3, .3, .5f));
		addSequential(new TurnToHeading(-48f));
		addSequential(new AutoMove(1, -1, .5f));
	}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideBlue!!!");
	}
}
