package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WaitForGear extends Command {
	
	public void execute(){
		// do nothing. Just waiting for the gear to be pulled.
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// stop when there's no longer a gear, so invert the output.
		return !Robot.gear.Output();
	}
	
	public void end(){
		Robot.relay.relaySwitch(false);
	}

	public void initialize() {
		System.out.println("Executing WaitForGear!!!");
	}
}
