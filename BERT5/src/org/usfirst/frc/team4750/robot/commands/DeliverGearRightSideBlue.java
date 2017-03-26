package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearRightSideBlue extends CommandGroup {
	
	public DeliverGearRightSideBlue(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.14f));// (speed,speed,time)
		addSequential(new TurnToHeading(-47f));// angle of turning
		addSequential(new AutoMove(.3, -.3, 1.6f));// (speed,speed,time)
		addSequential(new WaitForGear());
		addSequential(new AutoMove(-.3, .3, .5f));// (speed,speed,time)
		
		addSequential(new TurnToHeading(47f));
		addSequential(new AutoMove(1, -1, .5f));
	}

	public void initialize() {
		System.out.println("Executing DeliverGearRightSideBlue!!!");
	}
}
