package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideRed extends CommandGroup {
	
	public DeliverGearLeftSideRed(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.15f));
		addSequential(new TurnToHeading(48f));
		addSequential(new AutoMove(.3, -.3, 1.6f));
		addSequential(new WaitForGear());
		addSequential(new AutoMove(-.3, .3, .5f));
		addSequential(new TurnToHeading(-48f));
		addSequential(new AutoMove(1, -1, .5f));
	}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideRed!!!");
	}
}
