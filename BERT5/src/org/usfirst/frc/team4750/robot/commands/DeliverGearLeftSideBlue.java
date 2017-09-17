package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//starting right
public class DeliverGearLeftSideBlue extends CommandGroup {

	public DeliverGearLeftSideBlue() {
		// SmartDashboard.putBoolean("AutoDriveForwardAndTurn.AutoDriveForwardAndTurn()",true);
		addSequential(new OpenServo()); // Opens servo
		addSequential(new AutoMove(.3, -.3, 2.1f)); // (speed,speed,time)
		addSequential(new TurnToHeading(45.5f)); // Angle of turn
		addSequential(new AutoMove(.3, -.3, 1.6f)); // (speed,speed,time)
		addSequential(new WaitForGear()); // Waits for gear
		addSequential(new AutoMove(-.3, .3, .5f)); // (speed,speed,time)

		// addSequential(new TurnToHeading(100f)); //Turning to shoot
		// addSequential(new AutoMove(.3,-.3,2.45f)); // (speed,speed,time)
		// addSequential(new TurnToHeading(45f)); // Adjust for shooting
		// addSequential(new AutoShoot()); //Shoots balls

		addSequential(new TurnToHeading(-45.5f)); // Angle of turn
		addSequential(new AutoMove(1, -.9, .7f)); // (speed,speed,time)

	}

	public void initialize() {
		System.out.println("Executing DeliverGearLeftSideBlue!!!");
	}
}
