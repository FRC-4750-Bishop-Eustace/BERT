package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WaitForGear extends Command {
	

	public void execute(){
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.gear.Output();
	}
	
	public void end(){
		Robot.relay.relaySwitch(false);
	}

}
