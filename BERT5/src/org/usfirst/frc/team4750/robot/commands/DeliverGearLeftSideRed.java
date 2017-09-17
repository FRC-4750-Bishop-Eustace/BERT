package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideRed extends CommandGroup {

	public DeliverGearLeftSideRed() {
		// SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new OpenServo()); // Opens servo
		addSequential(new AutoMove(.3, -.3, 2.19f)); // (speed,speed,time)
		addSequential(new TurnToHeading(47f)); // Angle of turn
		addSequential(new TrackGear()); // Tracks gear peg
		addSequential(new AutoMove(.3, -.3, 1.63f)); // (speed,speed,time)
		addSequential(new WaitForGear()); // Waits for gear
		addSequential(new AutoMove(-.3, .3, .5f)); // (speed,speed,time)

		addSequential(new TurnToHeading(-47f)); // Angle of turning
		addSequential(new AutoMove(1, -1, .6f)); // (speed,speed,time)
	}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideRed!!!");
	}
}
