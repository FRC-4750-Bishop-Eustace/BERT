package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4750.robot.Robot;

public class SwitchCamera extends Command {

	// Creates boolean
	boolean isFinished = false;

	public SwitchCamera() {
		// requires(Robot.camera);
	}

	protected void execute() {
		// Calls camera cycle
		Robot.camera.cycle();
		// Sets boolean to true
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}

}
