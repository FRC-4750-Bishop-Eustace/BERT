package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4750.robot.Robot;

public class SwitchCamera extends Command {
	boolean finished = false;
	
	public SwitchCamera(){
		requires(Robot.camera);
	}
	
	protected void execute(){
		Robot.camera.cycle();
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

}
