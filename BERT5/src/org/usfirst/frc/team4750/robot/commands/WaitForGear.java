package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForGear extends Command {

	public void execute() {
		// Waits for gear to be taken
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// stop when there's no longer a gear, so invert the output.
		return !Robot.gear.Output();
	}

	public void end() {
		// Sets motor speeds to reverse
		Robot.driveTrain.setDriveMotors(.3, -.3);
		Timer.delay(.5);
		// Sets motor speeds to 0
		Robot.driveTrain.setDriveMotors(0, 0);
		// Turns relay switch (LED) off
		Robot.relay.relaySwitch(false);
	}

	public void initialize() {
		System.out.println("Executing WaitForGear!!!");
	}
}
