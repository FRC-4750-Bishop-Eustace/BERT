package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideBlue extends CommandGroup {
	
	public DeliverGearLeftSideBlue(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.6f));
		addSequential(new TurnToHeading(60f));
		addSequential(new AutoMove(.3, -.3, 1.6f));
		addSequential(new WaitForGear());
		addSequential(new AutoMove(-.3, .3, .3f));
		addSequential(new TurnToHeading(-60f));
		addSequential(new AutoMove(1, -1, 1f));
	}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideBlue!!!");
	}
}
