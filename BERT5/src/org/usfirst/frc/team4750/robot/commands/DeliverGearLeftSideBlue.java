package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideBlue extends CommandGroup {
	
	public DeliverGearLeftSideBlue(){
		//SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new AutoMove(.3, -.3, 2.1f)); // (speed,speed,time)
		addSequential(new TurnToHeading(45.5f)); //angle of turning
		addSequential(new AutoMove(.3, -.3, 1.6f));// (speed,speed,time)
		addSequential(new WaitForGear());	
		addSequential(new AutoMove(-.3, .3, .5f));// (speed,speed,time)
		
		addSequential(new TurnToHeading(100f));// turning for shooting
		addSequential(new AutoMove(.3,-.3,2.45f));// (speed,speed,time)
		addSequential(new TurnToHeading(45f));// line up shot
		addSequential(new AutoShoot());// shoots balls
		
		addSequential(new TurnToHeading(-48f));
		addSequential(new AutoMove(1, -1, .56f));
		
		}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideBlue!!!");
	}
}
