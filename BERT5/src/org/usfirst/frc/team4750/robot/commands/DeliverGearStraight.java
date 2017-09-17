package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeliverGearStraight extends CommandGroup {

	public DeliverGearStraight() {
		addSequential(new OpenServo()); // Opens servo
		addSequential(new AutoMove(.3, -.3, .2)); // (speed,speed,time)
		addSequential(new TrackGear()); // Tracks gear peg
		addSequential(new AutoMove(.3, -.3, 1.9f)); // (speed,speed,time)
		addSequential(new WaitForGear()); // Waits for gear

		addSequential(new AutoMove(-.3, .3, 1.4f));

		// addSequential(new TurnToHeading(78f)); // Red side
		addSequential(new TurnToHeading(-78f)); // Blue side

		addSequential(new AutoMove(.3, -.3, .5f)); // (speed,speed,time)
		addSequential(new AutoShoot()); // Shoots balls
	}

	public void initialize() {
		System.out.println("Executing DeliverGearStraight!!!");
	}
}
