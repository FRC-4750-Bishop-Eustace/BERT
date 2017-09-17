package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeliverGearStraight extends CommandGroup {

	public DeliverGearStraight() {
		addSequential(new OpenServo());
		addSequential(new AutoMove(.3, -.3, 1.9f));// (speed,speed,time)
		addSequential(new WaitForGear());

		addSequential(new AutoMove(-.3, .3, 1.4f));

		// addSequential(new TurnToHeading(78f));//red side
		addSequential(new TurnToHeading(-78f));// blue side

		addSequential(new AutoMove(.3, -.3, .5f));
		addSequential(new AutoShoot());

		// backup, 2xTurn, move foward .3, shoot
	}

	public void initialize() {
		System.out.println("Executing DeliverGearStraight!!!");
	}
}
